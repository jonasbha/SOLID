import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class The_program {
    @Test
    public void sums_numbers() throws IOException {
        String expected =
            "1 + 1 = 2\n" +
            "1 + 2 = 3\n" +
            "5 + 10 = 15\n" +
            "1205 + 795 = 2000\n" +
            "Total: 2020\n";
        StringBuilder actual = new CalculatorProgram().readParseCalculateAndFormat();
        assertEquals(expected, actual.toString());
    }

    @Test
    public void subtracts_numbers() throws IOException {
        String expected =
            "1 - 1 = 0\n" +
            "1 - 2 = -1\n" +
            "5 - 10 = -5\n" +
            "1205 - 795 = 410\n" +
            "Total: -404\n";
        StringBuilder actual = new SubtractionProgram().readParseCalculateAndFormat();
        assertEquals(expected, actual.toString());
    }
}
