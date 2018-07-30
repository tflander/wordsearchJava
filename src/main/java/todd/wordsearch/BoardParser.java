package todd.wordsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BoardParser {
    public Board parse(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/" + filePath));
        String[] validWords = lines.get(0).split(",");
        lines.remove(0);
        return new Board(lines, Arrays.asList(validWords));
    }
}
