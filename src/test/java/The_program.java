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
        StringBuilder actual = Program.readParseCalculateAndFormat();
        assertEquals(expected, actual.toString());
    }
}
