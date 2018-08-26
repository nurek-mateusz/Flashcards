export class Card {
    public id: number
    public question: string;
    public answer: string;
    public box: string;

    constructor(id: number, question: string, answer: string, box: string) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.box = box; 
    }
}