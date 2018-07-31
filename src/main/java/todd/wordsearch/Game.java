package todd.wordsearch;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Board board;

    public Game(String filePath) {
        board = new BoardParser().parse(filePath);
    }

    public List<String> solve() {
        return board.getValidWords()
                .stream()
                .map(this::solveWord)
                .collect(Collectors.toList());
    }

    private String solveWord(String word) {
        return word + ": " + asCoordinateString(board.find(word));
    }

    private String asCoordinateString(List<GridCoordinate> gridCoordinates) {
        StringBuilder sb = new StringBuilder();
        gridCoordinates.forEach(coord -> {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append("(" + coord.getX() + "," + coord.getY() + ")");
        });
        return sb.toString();
    }
}
