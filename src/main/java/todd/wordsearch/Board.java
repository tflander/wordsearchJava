package todd.wordsearch;

import java.util.Arrays;
import java.util.List;

public class Board {

    private final Grid grid;
    private final List<String> validWords;

    public Board(List<String> grid, List<String> validWords) {

        this.grid = new Grid(grid);
        this.validWords = validWords;
    }

    public List<GridCoordinate> find(String wordToFind) {
        if (!validWords.contains(wordToFind)) {
            throw new IllegalArgumentException("Word [" + wordToFind + "] is not valid for the board.");
        }

        for (int xDir = -1; xDir <= 1; ++xDir) {
            for (int yDir = -1; yDir <= 1; ++yDir) {
                if (xDir != 0 || yDir != 0) {
                    for (int y = 0; y < grid.height(); ++y) {
                        for (int x = 0; x < grid.width(); ++x) {
                            if (matchesWordWithDirection(wordToFind, xDir, yDir, x, y)) {
                                return Arrays.asList(
                                        new GridCoordinate(x, y),
                                        new GridCoordinate(x + xDir, y + yDir));
                            }
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("word not found");
    }

    private boolean matchesWordWithDirection(String wordToFind, int xDir, int yDir, int x, int y) {
        int currX = x;
        int currY = y;
        for (int pos = 0; pos < wordToFind.length(); ++pos) {
            if (grid.get(currX, currY) != wordToFind.charAt(pos)) {
                return false;
            }
            currX += xDir;
            currY += yDir;
            if(pos == wordToFind.length() -1) {
                break;
            }
            if(currX < 0 || currY < 0 || currX >= grid.width() || currY >= grid.height()) {
                return false;
            }
        }
        return true;
    }

    public Grid getGrid() {
        return grid;
    }

    public List<String> getValidWords() {
        return validWords;
    }
}
