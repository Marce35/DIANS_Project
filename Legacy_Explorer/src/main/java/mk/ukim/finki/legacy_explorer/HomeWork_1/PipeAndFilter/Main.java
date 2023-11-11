package mk.ukim.finki.legacy_explorer.HomeWork_1.PipeAndFilter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String data;
    public static Pipe<String> pipe = new Pipe<>();

    public static void addFilters() {
        pipe.addFilter(new RemoveEmptyColumnsFilter());
        pipe.addFilter(new CyrillicToLatinConverterFilter());
    }

    public static void main(String[] args) throws IOException {

        ClassLoader loader = Main.class.getClassLoader();
        Scanner scanner = new Scanner(new File(loader.getResource("database.csv").getFile()));


        StringBuilder csvData = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            csvData.append(line).append("\n");
        }

        data = csvData.toString();

        addFilters();
        data = pipe.runFilters(data);
        System.out.println(data);
    }
}
