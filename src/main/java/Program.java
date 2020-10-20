import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        CalculatorProgram program =
            args.length > 0 && "sub".equals(args[0])
            ? new SubtractionProgram()
            : new CalculatorProgram();
        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.println(resultBuilder.toString());
    }
}
