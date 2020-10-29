import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Parsing_expressions_from_CSV {

    @Test
    public void builds_list_of_binary_expressions() throws Exception {
        final String input =
            "X,Y\n" +
            "1,1\n" +
            "1,3\n";
        final BinaryExpression[] expected = new BinaryExpression[]{
            new BinaryExpression(1, new Addition(), 1),
            new BinaryExpression(1, new Addition(), 3)
        };
        ExpressionReader fakeReader = new FileExpressionReader() {
            @Override
            public String readData() throws IOException {
                return input;
            }
        };

        ExpressionParser parser = new ExpressionParser(fakeReader, new Addition(), new Addition());
        Aggregation actual = (Aggregation)parser.parseExpressions();

        Assertions.assertArrayEquals(expected, actual.operations);
    }

}
