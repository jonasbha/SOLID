import java.io.IOException;
import java.util.Scanner;

public class TerminalExpressionReader implements ExpressionReader {
    @Override
    public String readData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
