import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws IOException {
        // Read data from file at user.dir/data/additions.csv
        Path path = Paths.get(System.getProperty("user.dir"), "data", "additions.csv");
        byte[] encoded = Files.readAllBytes(path);
        String data = new String(encoded, "UTF-8");
        // Split data at unix line specifier
        String[] lines = data.split("\n");
        // Prepare total
        int total = 0;

        StringBuilder resultBuilder = new StringBuilder();

        // Iterate lines
        for(int i = 0; i<lines.length; i++) {
            // Skip first line
            if (lines[i].startsWith("X")) {
                continue;
            }
            // Split line on comma delimiter
            String[] columns = lines[i].split(",");
            // Parse integers
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);
            // Aggregate grand total
            total += x + y;
            // Print first part of calculation
            resultBuilder.append(columns[0] + " + " + columns[1]);
            // Print total
            resultBuilder.append(" = " + (x + y) + "\n");
        }
        // Print grand total
        resultBuilder.append("Total: " + total + "\n");

        System.out.println(resultBuilder.toString());
    }
}
