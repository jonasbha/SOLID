import java.util.Arrays;

public abstract class Aggregation {
    int total;
    public BinaryExpression[] operations;

    public Aggregation() {
    }

    final void calculate(BinaryExpression[] operations) {
        total = Arrays.stream(operations)
                .map(x -> x.calculate())
                .reduce(0, this::aggregateTotal);
        this.operations = operations;
    }

    protected abstract int aggregateTotal(int total, int subtotal);
}