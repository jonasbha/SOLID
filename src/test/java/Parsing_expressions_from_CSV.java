import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Parsing_expressions_from_CSV {

    @ParameterizedTest
    @ValueSource(chars={'+', '-'})
    public void builds_list_of_binary_expressions_for_given_operator(char operator) {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            new BinaryExpression(1, operator, 1),
            new BinaryExpression(1, operator, 3)
        };

        ExpressionParser parser = new ExpressionParser(operator);
        BinaryExpression[] actual = parser.parseOperations(input);

        Assertions.assertArrayEquals(expected, actual);
    }

}
