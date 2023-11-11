package mk.ukim.finki.legacy_explorer.HomeWork_1.PipeAndFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String data;
    public static Pipe<String> pipe;

    public static void addFilters() {
        //pipe.addFilter();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String csvFilePath = "path/to/your/file.csv";

        Scanner scanner = new Scanner(new File(csvFilePath));
        StringBuilder csvData = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            csvData.append(line).append("\n");
        }

        data = csvData.toString();
        addFilters();
        pipe.runFilters(data);
    }
}
