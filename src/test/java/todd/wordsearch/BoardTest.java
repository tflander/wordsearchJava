package todd.wordsearch;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        List<String> grid = asList("ABC",
                "DEF",
                "GHI");
        List<String> validWords = asList(new String[]{
                "AB",
                "BC",
                "DE",
                "AD"
        });
        board = new Board(grid, validWords);
    }

    @Test
    public void findsAB() {
        List<GridCoordinate> expectedCoords = asList(
                new GridCoordinate(0, 0),
                new GridCoordinate(1, 0));
        assertThat(board.find("AB")).isEqualTo(expectedCoords);
    }

    @Test
    public void findsBC() {
        List<GridCoordinate> expectedCoords = asList(
                new GridCoordinate(1, 0),
                new GridCoordinate(2, 0));
        assertThat(board.find("BC")).isEqualTo(expectedCoords);
    }

    @Test
    public void findsDE() {
        List<GridCoordinate> expectedCoords = asList(
                new GridCoordinate(0, 1),
                new GridCoordinate(1, 1));
        assertThat(board.find("DE")).isEqualTo(expectedCoords);
    }

    @Test
    public void findsAD() {
        List<GridCoordinate> expectedCoords = asList(
                new GridCoordinate(0, 0),
                new GridCoordinate(0, 1));
        assertThat(board.find("AD")).isEqualTo(expectedCoords);
    }

    @Test
    public void doesNotFindInvalidWord() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Word [Invalid Word] is not valid for the board");
        board.find("Invalid Word");
    }
}
