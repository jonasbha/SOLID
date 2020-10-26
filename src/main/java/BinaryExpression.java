import java.util.Objects;

public class BinaryExpression {
    public final int left;
    public final BinaryOperator operator;
    public final int right;

    public BinaryExpression(int left, BinaryOperator operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public int calculate() {
        return operator.calculate(left, right);
    }

    @Override
    public String toString() {
        return left + " " + operator.symbol + " " + right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryExpression)) return false;
        BinaryExpression that = (BinaryExpression) o;
        return left == that.left &&
                right == that.right &&
                operator.equals(that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, operator, right);
    }
}
