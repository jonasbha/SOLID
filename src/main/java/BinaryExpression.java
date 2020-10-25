import java.lang.reflect.Constructor;
import java.util.Objects;

public class BinaryExpression {
    public final int left;
    protected final BinaryOperator operator;
    public final int right;

    protected BinaryExpression(int left, BinaryOperator operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public static BinaryExpression create(Integer x, char operator, Integer y) {
        try {
            return new BinaryExpression(x, BinaryOperator.create(operator), y);
        } catch (Exception e) {
            return null;
        }
    }

    public static BinaryExpression create(Class operatorType, Integer x, Integer y) {
        try {
            return new BinaryExpression(x, (BinaryOperator)operatorType.newInstance(), y);
        } catch (Exception e) {
            return null;
        }
    }

    public int calculate() {
        return operator.calculate(left, right);
    }

    @Override
    public String toString() {
        return this.left + " " + this.operator + " " + this.right;
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
        return Objects.hash(left, right, operator);
    }
}
