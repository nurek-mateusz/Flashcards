package flashcards.model;

import java.util.Arrays;

public enum Box {

    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), LEARNED(6);

    private int boxId;

    Box(int boxId) {
        this.boxId = boxId;
    }

    public static Box getBoxById(int boxId) {
        return Arrays.stream(values())
                .filter(b -> b.boxId == boxId)
                .findFirst()
                .orElse(Box.ONE);
    }

}
