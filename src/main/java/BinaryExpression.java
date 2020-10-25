import java.util.Objects;

public class BinaryExpression {
    public final int left;
    public final int right;

    public BinaryExpression(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return this.left + " (op) " + this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryExpression)) return false;
        BinaryExpression that = (BinaryExpression) o;
        return left == that.left &&
                right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
