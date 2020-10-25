import java.util.Arrays;
import java.util.function.BinaryOperator;

public class AggregateExpression {
    int total;

    public AggregateExpression() {
    }

    final void calculate(BinaryOperator<Integer> accumulator, BinaryExpression[] operations) {
        total = Arrays.stream(operations)
                .map(x -> x.calculateItem())
                .reduce(0, accumulator);
    }


}