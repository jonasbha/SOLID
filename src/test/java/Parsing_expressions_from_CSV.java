import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Parsing_expressions_from_CSV {

    @Test
    public void builds_list_of_binary_expressions() {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            new BinaryExpression(1, 1),
            new BinaryExpression(1, 3)
        };

        ExpressionParser parser = new ExpressionParser();
        Object[] actual = parser.parseOperations(input);

        Assertions.assertArrayEquals(expected, actual);
    }

}
