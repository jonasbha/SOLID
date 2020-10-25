package parsing;

import io.ExpressionReader;
import model.BinaryExpression;
import model.BinaryOperator;

import java.io.IOException;
import java.util.concurrent.Callable;

public class ExpressionParser {
    private final String input;
    private final Callable<BinaryOperator> operatorFactory;

    public ExpressionParser(ExpressionReader reader, Class expressionType) throws Exception {
        this.input = reader.readData();
        operatorFactory = () -> (BinaryOperator) expressionType.newInstance();
    }

    public ExpressionParser(ExpressionReader reader, BinaryOperator operator) throws IOException {
        this.input = reader.readData();
        this.operatorFactory = () -> operator;
    }

    public BinaryExpression[] parseOperations() throws Exception {
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

            operations[i - 1] = BinaryExpression.create(x, operatorFactory.call(), y);
        }
        return operations;
    }
}