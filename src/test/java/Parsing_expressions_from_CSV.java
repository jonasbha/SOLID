import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

public class Parsing_expressions_from_CSV {

    @Test
    public void builds_list_of_binary_expressions() throws IOException {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            BinaryExpression.addition.apply(1).apply(1),
            BinaryExpression.addition.apply(1).apply(3)
        };
        ExpressionReader fakeReader = new ExpressionReader() {
            @Override
            public String readData() throws IOException {
                return input;
            }
        };

        ExpressionParser parser = new ExpressionParser(fakeReader, BinaryExpression.addition);
        BinaryExpression[] actual = parser.parseOperations();

        Assertions.assertArrayEquals(expected, actual);
    }

}
