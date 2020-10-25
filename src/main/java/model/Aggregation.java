package model;

import java.util.Arrays;

public class Aggregation {
    private final BinaryOperator operator;
    public final BinaryExpression[] operations;
    public int total;

    public Aggregation(BinaryOperator operator, BinaryExpression[] operations) {
        this.operator = operator;
        this.operations = operations;
    }

    public final void calculate() {
        total = Arrays.stream(this.operations)
            .map(x -> x.calculate())
            .reduce(0, (total, subtotal) -> operator.calculate(total, subtotal));
    }
}