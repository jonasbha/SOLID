import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        MutablePicoContainer container = new DefaultPicoContainer();

        container.addComponent(ExpressionReader.class);
        container.addComponent(ExpressionParser.class);
        container.addComponent(CalculatorProgram.class);

        container.addComponent(
            BinaryOperator.class,
            shouldUseSubtraction(args)
                ? Subtraction.class
                : Addition.class
        );


        CalculatorProgram program = container.getComponent(CalculatorProgram.class);

        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
