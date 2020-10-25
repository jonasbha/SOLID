import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class ExpressionParser {
    private final char operator;
    private final String input;

    public ExpressionParser(char operator, ExpressionReader reader) throws IOException {
        this.operator = operator;
        this.input = reader.readData();
    }

    BinaryExpression[] parseOperations() {
        // Split data at unix line specifier
        String[] lines = input.split("\n");

        BinaryExpression[] operations = new BinaryExpression[lines.length - 1];

        // Iterate lines
        for (int i = 0; i < lines.length; i++) {
            // Skip first line
            if (lines[i].startsWith("X")) {
                continue;
            }
            // Split line on comma delimiter
            String[] columns = lines[i].split(",");
            // Parse integers
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);

            Function<Integer, Function<Integer, BinaryExpression>> factory = a -> b -> new BinaryExpression(a, operator, b);
            operations[i - 1] = factory.apply(x).apply(y);
        }
        return operations;
    }
}