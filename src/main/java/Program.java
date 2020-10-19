import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        StringBuilder resultBuilder = new CalculatorProgram().readParseCalculateAndFormat();

        System.out.println(resultBuilder.toString());
    }
}
