package flashcards.controller;

import flashcards.model.Box;
import flashcards.model.Card;
import flashcards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/box/{boxId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> getAllCardsInBox(@PathVariable int boxId) {
        Box selectedBox = Box.getBoxById(boxId);
        return cardService.getAllCardsFromBox(selectedBox);
    }

    @PutMapping(value = "/card/{cardId}/{answer}")
    public void saveUserAnswer(@PathVariable long cardId, @PathVariable boolean answer) {
        cardService.moveCardToNewBox(cardId, answer);
    }

    @PostMapping(value = "/card", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewCard(@RequestBody Card card) {
        cardService.saveCard(card);
    }

}
