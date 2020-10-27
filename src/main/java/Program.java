import org.picocontainer.Characteristics;
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
        container.as(Characteristics.USE_NAMES).addComponent(ExpressionParser.class);
        container.addComponent(Reporter.class, AsciiReporter.class);
        container.as(Characteristics.USE_NAMES).addComponent(CalculatorProgram.class);

        container.addComponent("operator",
            shouldUseSubtraction(args, 0)
                ? Subtraction.class
                : Addition.class
        );
        container.addComponent("aggregationOperator",
            shouldUseSubtraction(args, 1)
                ? Subtraction.class
                : Addition.class
        );

        return container;
    }

    private static boolean shouldUseSubtraction(String[] args, int index) {
        return args.length > index && "sub".equals(args[index]);
    }

}
