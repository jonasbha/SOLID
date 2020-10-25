import io.ExpressionReader;
import model.BinaryExpression;
import model.BinaryOperator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parsing.ExpressionParser;

import java.io.IOException;

public class Parsing_expressions_from_CSV {

    @ParameterizedTest
    @ValueSource(chars={'+', '-'})
    public void builds_list_of_binary_expressions(char operator) throws Exception {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            BinaryExpression.create(1, operator, 1),
            BinaryExpression.create(1, operator, 3)
        };
        ExpressionReader fakeReader = new ExpressionReader() {
            @Override
            public String readData() throws IOException {
                return input;
            }
        };

        ExpressionParser parser = new ExpressionParser(fakeReader, BinaryOperator.create(operator));
        BinaryExpression[] actual = parser.parseOperations();

        Assertions.assertArrayEquals(expected, actual);
    }

}
