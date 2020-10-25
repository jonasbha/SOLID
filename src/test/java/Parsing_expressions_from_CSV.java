import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

public class Parsing_expressions_from_CSV {

    @ParameterizedTest
    @ValueSource(chars={'+', '-'})
    public void builds_list_of_binary_expressions_for_given_operator(char operator) throws IOException {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            new BinaryExpression(1, operator, 1),
            new BinaryExpression(1, operator, 3)
        };
        ExpressionReader fakeReader = new ExpressionReader() {
            @Override
            public String readData() throws IOException {
                return input;
            }
        };

        ExpressionParser parser = new ExpressionParser(operator, fakeReader);
        BinaryExpression[] actual = parser.parseOperations();

        Assertions.assertArrayEquals(expected, actual);
    }

}
