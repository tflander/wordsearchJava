package todd.wordsearch;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardParserTest {

    @Test
    public void parses() throws IOException {
        Board board = new BoardParser().parse("tiny.board");
        assertThat(board.getValidWords()).contains("AB", "BC");
    }
}
