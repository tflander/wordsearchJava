package todd.wordsearch;

import org.junit.Test;

import static todd.wordsearch.customAssertion.CoordinateAssert.assertThat;

public class TrekTest {

    private final Board board = new BoardParser().parse("trek.board");

    /*
KHAN: (5,9),(5,8),(5,7),(5,6)
KIRK: (4,7),(3,7),(2,7),(1,7)
SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)
SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)
SULU: (3,3),(2,2),(1,1),(0,0)
UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)
     */

    @Test
    public void findsBonesVerticalDown() {
        assertThat(board.find("BONES")).matchesCoordinates("(0,6),(0,7),(0,8),(0,9),(0,10)");
    }

    @Test
    public void findsKhanVerticalUp() {
        assertThat(board.find("KHAN")).matchesCoordinates("(5,9),(5,8),(5,7),(5,6)");
    }

    @Test
    public void findsKirkHorizontalBackwards() {
        assertThat(board.find("KIRK")).matchesCoordinates("(4,7),(3,7),(2,7),(1,7)");
    }

    @Test
    public void findsScottyHorizontalForwards() {
        assertThat(board.find("SCOTTY")).matchesCoordinates("(0,5),(1,5),(2,5),(3,5),(4,5),(5,5)");
    }

    @Test
    public void findsSpockTopLeftToLowerRight() {
        assertThat(board.find("SPOCK")).matchesCoordinates("(2,1),(3,2),(4,3),(5,4),(6,5)");
    }

    @Test
    public void findsSuluBottomRightToUpperLeft() {
        assertThat(board.find("SULU")).matchesCoordinates("(3,3),(2,2),(1,1),(0,0)");
    }

    @Test
    public void findsUhuraTopRightToLowerLeft() {
        assertThat(board.find("UHURA")).matchesCoordinates("(4,0),(3,1),(2,2),(1,3),(0,4)");
    }

}
