import { Component, OnInit } from '@angular/core';
import { CardService } from '../shared/card.service';
import { Card } from '../shared/card.model';

@Component({
  selector: 'app-add-card',
  providers: [CardService],
  templateUrl: './add-card.component.html',
  styleUrls: ['./add-card.component.css']
})
export class AddCardComponent implements OnInit {

  constructor(private cardService: CardService) { }

  ngOnInit() {
  }

  saveCard(question: string, answer: string) {
    let card = new Card(null, question, answer, 'ONE');
    this.cardService.createCard(card);
  }

}
