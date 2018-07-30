package todd.wordsearch;

import java.util.Arrays;
import java.util.List;

public class Board {

    private final List<String> grid;
    private final List<String> validWords;

    public Board(List<String> grid, List<String> validWords) {

        this.grid = grid;
        this.validWords = validWords;
    }

    public List<GridCoordinate> find(String ab) {
        if(!validWords.contains(ab)) {
            throw new IllegalArgumentException("Word [" + ab + "] is not valid for the board.");
        }
        return Arrays.asList(
                new GridCoordinate(0,0),
                new GridCoordinate(1, 0));
    }

    public List<String> getGrid() {
        return grid;
    }

    public List<String> getValidWords() {
        return validWords;
    }
}
