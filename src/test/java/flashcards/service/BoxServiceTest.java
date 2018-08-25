package flashcards.service;

import flashcards.model.Box;
import org.junit.Assert;
import org.junit.Test;

public class BoxServiceTest {

    @Test
    public void getNextBoxWhenCorrectAnswer() {
        // given
        Box currentBox = Box.ONE;
        boolean answerIsCorrect = true;
        BoxService boxService = new BoxService();

        // when
        Box newBox = boxService.getNextBox(currentBox);

        //then
        Assert.assertEquals(Box.TWO, newBox);
    }

    @Test
    public void getPreviousBoxWhenIncorrectAnswer() {
        // given
        Box currentBox = Box.TWO;
        boolean answerIsCorrect = false;
        BoxService boxService = new BoxService();

        // when
        Box newBox = boxService.getPreviousBox(currentBox);

        //then
        Assert.assertEquals(Box.ONE, newBox);
    }

}
