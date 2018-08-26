import { Card } from './card.model';
import {map} from 'rxjs/operators';
import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Response} from '@angular/http'

@Injectable()
export class CardService {

    URL = 'http://localhost:8080/';

    constructor(private http: HttpClient){}

    getAllCardsFromBox(boxId: number) {
        return this.http.get<Card[]>('http://localhost:8080/box/' + boxId);
    }

    sendUserAnswer(cardId: number, answer: boolean) {
        this.http.put('http://localhost:8080/card/' + cardId + "/" + answer, null).subscribe();
    }

    createCard(card: Card) {
        this.http.post('http://localhost:8080/card/', card).subscribe();
    }
  }