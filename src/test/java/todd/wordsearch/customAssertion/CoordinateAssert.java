package todd.wordsearch.customAssertion;

import org.assertj.core.api.AbstractAssert;
import todd.wordsearch.GridCoordinate;

import java.util.List;

public class CoordinateAssert extends AbstractAssert<CoordinateAssert, List<GridCoordinate>> {

    public CoordinateAssert(List<GridCoordinate> actual) {
        super(actual, CoordinateAssert.class);
    }

    public static CoordinateAssert assertThat(List<GridCoordinate> actual) {
        return new CoordinateAssert(actual);
    }

    public CoordinateAssert matchesCoordinates(String expectedCoordinates) {
        isNotNull();

        String actualAsString = actualAsString();

        if (!actualAsString.equals(expectedCoordinates)) {
            failWithMessage("Expected coordinates to be <%s> but was <%s>", expectedCoordinates, actualAsString);
        }

        return this;
    }

    private String actualAsString() {
        StringBuilder sb = new StringBuilder();
        actual.forEach(coordinate -> {
            if(sb.length() > 0) {
                sb.append(",");
            }
            sb.append("(")
                    .append(coordinate.getX())
                    .append(",")
                    .append(coordinate.getY())
                    .append(")");
        });
        return sb.toString();
    }
}
