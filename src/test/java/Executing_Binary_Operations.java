import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Executing_Binary_Operations {
    @Nested
    public class When_adding {
        @Test
        public void calculates_sum() {
            BinaryExpression expression = new BinaryExpression(1, new Addition(), 2);
            assertEquals(3, expression.calculate());
        }
    }

    @Nested
    public class When_subtracting {
        @Test
        public void calculates_difference() {
            BinaryExpression expression = new BinaryExpression(1, new Subtraction(), 2);
            assertEquals(-1, expression.calculate());
        }
    }
}
