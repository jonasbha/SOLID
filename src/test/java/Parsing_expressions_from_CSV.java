import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

public class Parsing_expressions_from_CSV {

    @ParameterizedTest
    @ValueSource(classes={Addition.class, Subtraction.class})
    public void builds_list_of_binary_expressions(Class expressionType) throws Exception {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            BinaryExpression.createExpression(expressionType, 1, 1),
            BinaryExpression.createExpression(expressionType, 1, 3)
        };
        ExpressionReader fakeReader = new ExpressionReader() {
            @Override
            public String readData() throws IOException {
                return input;
            }
        };

        ExpressionParser parser = new ExpressionParser(fakeReader, expressionType);
        BinaryExpression[] actual = parser.parseOperations();

        Assertions.assertArrayEquals(expected, actual);
    }

}
