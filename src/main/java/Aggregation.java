public class Aggregation implements Expression {
    public BinaryOperator aggregationOperator;
    public final BinaryExpression[] operations;
    public int total;

    public Aggregation(BinaryOperator aggregationOperator, BinaryExpression[] operations) {
        this.aggregationOperator = aggregationOperator;
        this.operations = operations;
    }

    @Override
    public final int calculate() {
        total = 0;
        for (int i = 0; i < operations.length; i++) {
            total = aggregationOperator.calculate(total, operations[i].calculate());
        }
        return total;
    }
}
