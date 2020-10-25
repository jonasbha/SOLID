import java.util.Arrays;
import java.util.function.BinaryOperator;

public abstract class AggregateExpression {
    int total;

    public AggregateExpression() {
    }

    final void calculate(BinaryExpression[] operations) {
        total = Arrays.stream(operations)
                .map(x -> x.calculateItem())
                .reduce(0, this::aggregateTotal);
    }

    protected abstract int aggregateTotal(int total, int subtotal);
}