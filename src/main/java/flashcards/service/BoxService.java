package flashcards.service;

import flashcards.model.Box;
import org.springframework.stereotype.Service;

@Service
public class BoxService {

    public Box getNextBox(Box currentBox) {
        return getBox(currentBox, true);
    }

    public Box getPreviousBox(Box currentBox) {
        return getBox(currentBox, false);
    }

    private Box getBox(Box currentBox, boolean direction) {
        Box[] boxes = Box.values();
        int nextBoxIndex = 0;
        for(int i = 0; i < boxes.length; ++i) {
            if(currentBox == boxes[i]) {
                if(direction) {
                    nextBoxIndex = i == 0 ? 0 : i + 1;
                } else {
                    nextBoxIndex = i - 1;
                }
                break;
            }
        }
        return boxes[nextBoxIndex];
    }

}
