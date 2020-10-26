public class Aggregation {
    BinaryOperator aggregationOperator;

    public Aggregation(BinaryOperator aggregationOperator) {
        this.aggregationOperator = aggregationOperator;
    }

    final int calculate(BinaryExpression[] operations) {
        int total = 0;
        for (int i = 0; i < operations.length; i++) {
            total = this.aggregationOperator.calculate(total, operations[i].calculate());
        }
        return total;
    }
}
