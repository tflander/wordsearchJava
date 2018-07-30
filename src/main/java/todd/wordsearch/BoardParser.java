package todd.wordsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BoardParser {
    public Board parse(String filePath) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src/test/resources/" + filePath));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        String[] validWords = lines.get(0).split(",");
        lines.remove(0);
        return new Board(lines, Arrays.asList(validWords));
    }
}
