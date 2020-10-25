import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.function.Function;

public abstract class BinaryExpression {
    public final int left;
    protected final char operator;
    public final int right;

    protected BinaryExpression(int left, char operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public static BinaryExpression createExpression(Class expressionType, Integer x, Integer y) {
        try {
            Constructor constructor = expressionType.getConstructor(Integer.class, Integer.class);
            return (BinaryExpression) constructor.newInstance(x, y);
        } catch (Exception e) {
            return null;
        }
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
                operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, operator);
    }

    public abstract int calculateItem();
}
