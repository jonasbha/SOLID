import java.io.IOException;
import java.util.function.Function;

public class ExpressionParser {
    private final String input;
    private Function<Integer, Function<Integer, BinaryExpression>> expressionFactory;

    public ExpressionParser(ExpressionReader reader, Function<Integer, Function<Integer, BinaryExpression>> expressionFactory) throws IOException {
        this.input = reader.readData();
        this.expressionFactory = expressionFactory;
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

            operations[i - 1] = expressionFactory.apply(x).apply(y);
        }
        return operations;
    }
}