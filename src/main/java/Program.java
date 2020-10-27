import org.picocontainer.Characteristics;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Intercepted;
import org.picocontainer.behaviors.Intercepting;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        MutablePicoContainer container = configureApplication(args);
        addLogging(container);

        CalculatorProgram program = container.getComponent(CalculatorProgram.class);
        StringBuilder resultBuilder = program.readParseCalculateAndFormat();
        System.out.print(resultBuilder.toString());
    }

    private static void addLogging(MutablePicoContainer container) {
        container.getComponentAdapter(Reporter.class)
                .findAdapterOfType(Intercepted.class)
                .addPreInvocation(Reporter.class, new Reporter() {
                    @Override
                    public StringBuilder formatReport(Aggregation aggregation) {
                        System.out.println("Formatting report " + aggregation);
                        return null;
                    }
                });
    }

    private static MutablePicoContainer configureApplication(String[] args) {
        MutablePicoContainer container = new DefaultPicoContainer(new Intercepting());

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
