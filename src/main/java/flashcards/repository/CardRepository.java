package flashcards.repository;

import flashcards.model.Box;
import flashcards.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {

    List<Card> findByBox(Box box);

}
