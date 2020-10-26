public class Aggregation {
    public BinaryOperator aggregationOperator;
    public final BinaryExpression[] operations;
    public int total;

    public Aggregation(BinaryOperator aggregationOperator, BinaryExpression[] operations) {
        this.aggregationOperator = aggregationOperator;
        this.operations = operations;
    }

    final void calculate() {
        total = 0;
        for (int i = 0; i < operations.length; i++) {
            total = aggregationOperator.calculate(total, operations[i].calculate());
        }
    }
}
