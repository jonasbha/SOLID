import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        MutablePicoContainer container = configureApplication(args);
        CalculatorProgram program = container.getComponent(CalculatorProgram.class);
        StringBuilder resultBuilder = program.readParseCalculateAndFormat();
        System.out.print(resultBuilder.toString());
    }

    private static MutablePicoContainer configureApplication(String[] args) {
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
        return container;
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
