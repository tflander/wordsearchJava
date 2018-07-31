package todd.wordsearch;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class GameTest {

    @Test
    public void tinyGame() {
        List<String> answerKey = new Game("tiny.board").solve();
        Assertions.assertThat(answerKey).containsExactly(
                "AB: (0,0),(1,0)",
                "BC: (1,0),(2,0)"
        );
    }

    @Test
    public void trekGame() {
        List<String> answerKey = new Game("trek.board").solve();
        Assertions.assertThat(answerKey).containsExactly(
                "BONES: (0,6),(0,7),(0,8),(0,9),(0,10)",
                "KHAN: (5,9),(5,8),(5,7),(5,6)",
                "KIRK: (4,7),(3,7),(2,7),(1,7)",
                "SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)",
                "SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)",
                "SULU: (3,3),(2,2),(1,1),(0,0)",
                "UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)"
        );
    }

}
