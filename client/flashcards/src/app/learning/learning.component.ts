import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { CardService } from '../shared/card.service';
import { Card } from '../shared/card.model';

@Component({
  selector: 'app-learning',
  providers: [CardService],
  templateUrl: './learning.component.html',
  styleUrls: ['./learning.component.css']
})
export class LearningComponent implements OnInit {

  boxId: number;
  cards: Card[];
  currentCard: Card;

  answer = false;

  constructor(private route: ActivatedRoute, private router: Router, private cardService: CardService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.currentCard = new Card(null, '', '', '');
      this.boxId = +params['boxId'];
      this.cardService.getAllCardsFromBox(this.boxId).subscribe(
        (res) => {
          this.cards = res;
          if(this.cards.length > 0) {
            this.currentCard = this.cards[0];
          }
        }
      );
   });
  }

  showAnswer() {
    this.answer = true;
  }

  getUserAnswer(answer: boolean) {
    this.cards.splice(0, 1);
    if(!answer && this.currentCard.box === 'ONE') {
      this.cards.push(this.currentCard);
    }

    this.cardService.sendUserAnswer(this.currentCard.id, answer);

    if(this.cards.length == 0) {
      this.router.navigate(['/box']);
    }

    this.currentCard = this.cards[0];
    this.answer = false;
  }

}
