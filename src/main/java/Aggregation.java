import java.util.Arrays;

public class Aggregation {
    private final BinaryOperator operator;
    int total;
    public BinaryExpression[] operations;

    public Aggregation(BinaryOperator operator) {
        this.operator = operator;
    }

    final void calculate(BinaryExpression[] operations) {
        total = Arrays.stream(operations)
                .map(x -> x.calculate())
                .reduce(0, (total, subtotal) -> operator.calculate(total, subtotal));
        this.operations = operations;
    }
}