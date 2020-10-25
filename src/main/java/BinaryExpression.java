import java.util.Objects;

public class BinaryExpression {
    public final int left;
    protected final char operator;
    public final int right;

    public BinaryExpression(int left, char operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public int calculateItem() {
        if (operator == '+') {
            return left + right;
        } else {
            return left - right;
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
}
