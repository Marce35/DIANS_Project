package mk.ukim.finki.legacy_explorer.HomeWork_1.PipeAndFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveEmptyColumnsFilter implements Filter<String> {
    @Override
    public String execute(String data) {
        StringBuilder result = new StringBuilder();
        String[] lines = data.split("\\n");
        for (String line : lines) {
            String[] cells = line.split(",");

            List<String> modifiedCells = new ArrayList<>(Arrays.asList(cells));
            modifiedCells.remove(6);
            modifiedCells.remove(7);

            String modifiedLine = String.join(",", modifiedCells);
            result.append(modifiedLine).append("\n");

        }
        return result.toString();
    }
}
