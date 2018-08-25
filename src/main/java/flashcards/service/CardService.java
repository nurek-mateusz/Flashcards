package flashcards.service;

import flashcards.model.Box;
import flashcards.model.Card;
import flashcards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BoxService boxService;

    public List<Card> getAllCardsFromBox(Box box) {
        return cardRepository.findByBox(box);
    }

    public void moveCardToNewBox(long cardID, boolean correctAnswer) {
        Card card = cardRepository.findById(cardID)
                .orElseThrow(() -> new IllegalArgumentException("Card not exists"));

        Box newBox = null;
        if(correctAnswer) {
            newBox = boxService.getNextBox(card.getBox());
        } else {
            newBox = boxService.getPreviousBox(card.getBox());
        }

        card.setBox(newBox);

        cardRepository.save(card);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

}
