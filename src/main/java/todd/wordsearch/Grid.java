package todd.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final List<String> grid;

    public Grid(List<String> grid) {
        this.grid = new ArrayList<>();
        grid.forEach(rowWithCommas -> {
            this.grid.add(rowWithCommas.replaceAll(",", ""));
        });
    }

    public int height() {
        return grid.size();
    }

    public int width() {
        return grid.get(0).length();
    }

    public char get(int x, int y) {
        return grid.get(y).charAt(x);
    }
}
