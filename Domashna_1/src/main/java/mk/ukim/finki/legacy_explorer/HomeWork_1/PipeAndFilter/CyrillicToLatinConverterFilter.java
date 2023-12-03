package mk.ukim.finki.legacy_explorer.HomeWork_1.PipeAndFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CyrillicToLatinConverterFilter implements Filter<String> {

    public Map<String, String> MapInitializer() {
        Map<String, String> macedonianToEnglishMap = new HashMap<String, String>();
        macedonianToEnglishMap.put("А", "A");
        macedonianToEnglishMap.put("а", "a");
        macedonianToEnglishMap.put("Б", "B");
        macedonianToEnglishMap.put("б", "b");
        macedonianToEnglishMap.put("В", "V");
        macedonianToEnglishMap.put("в", "v");
        macedonianToEnglishMap.put("Г", "G");
        macedonianToEnglishMap.put("г", "g");
        macedonianToEnglishMap.put("Д", "D");
        macedonianToEnglishMap.put("д", "d");
        macedonianToEnglishMap.put("Ѓ", "Gj");
        macedonianToEnglishMap.put("ѓ", "gj");
        macedonianToEnglishMap.put("Е", "E");
        macedonianToEnglishMap.put("е", "e");
        macedonianToEnglishMap.put("Ж", "Zh");
        macedonianToEnglishMap.put("ж", "zh");
        macedonianToEnglishMap.put("З", "Z");
        macedonianToEnglishMap.put("з", "z");
        macedonianToEnglishMap.put("Ѕ", "Dz");
        macedonianToEnglishMap.put("ѕ", "dz");
        macedonianToEnglishMap.put("И", "I");
        macedonianToEnglishMap.put("и", "i");
        macedonianToEnglishMap.put("Ј", "J");
        macedonianToEnglishMap.put("ј", "j");
        macedonianToEnglishMap.put("К", "K");
        macedonianToEnglishMap.put("к", "k");
        macedonianToEnglishMap.put("Л", "L");
        macedonianToEnglishMap.put("л", "l");
        macedonianToEnglishMap.put("Љ", "Lj");
        macedonianToEnglishMap.put("љ", "lj");
        macedonianToEnglishMap.put("М", "M");
        macedonianToEnglishMap.put("м", "m");
        macedonianToEnglishMap.put("Н", "N");
        macedonianToEnglishMap.put("н", "n");
        macedonianToEnglishMap.put("Њ", "Nj");
        macedonianToEnglishMap.put("њ", "nj");
        macedonianToEnglishMap.put("О", "O");
        macedonianToEnglishMap.put("о", "o");
        macedonianToEnglishMap.put("П", "P");
        macedonianToEnglishMap.put("п", "p");
        macedonianToEnglishMap.put("Р", "R");
        macedonianToEnglishMap.put("р", "r");
        macedonianToEnglishMap.put("С", "S");
        macedonianToEnglishMap.put("с", "s");
        macedonianToEnglishMap.put("Т", "T");
        macedonianToEnglishMap.put("т", "t");
        macedonianToEnglishMap.put("Ќ", "Kj");
        macedonianToEnglishMap.put("ќ", "kj");
        macedonianToEnglishMap.put("У", "U");
        macedonianToEnglishMap.put("у", "u");
        macedonianToEnglishMap.put("Ф", "F");
        macedonianToEnglishMap.put("ф", "f");
        macedonianToEnglishMap.put("Х", "H");
        macedonianToEnglishMap.put("х", "h");
        macedonianToEnglishMap.put("Ц", "C");
        macedonianToEnglishMap.put("ц", "c");
        macedonianToEnglishMap.put("Ч", "Ch");
        macedonianToEnglishMap.put("ч", "ch");
        macedonianToEnglishMap.put("Џ", "Dz");
        macedonianToEnglishMap.put("џ", "dz");
        macedonianToEnglishMap.put("Ш", "Sh");
        macedonianToEnglishMap.put("ш", "sh");

        return macedonianToEnglishMap;
    }

    @Override
    public String execute(String inputData) {
        StringBuilder result = new StringBuilder();
        String[] lines = inputData.split("\\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            String name = parts[0];
            String city = parts[2];

            String convertedName = Converter(name);
            String convertedCity = Converter(city);

            parts[0] = convertedName;
            parts[2] = convertedCity;

            String modifiedLine = String.join(",", parts);
            result.append(modifiedLine).append("\n");
        }
        return result.toString();
    }


    public String Converter(String data) {
        Map<String, String> converterMap = MapInitializer();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            String c = data.substring(i, i + 1);
            String mappedCharacter = converterMap.get(c);
            result.append(Objects.requireNonNullElse(mappedCharacter, c));
        }
        return result.toString();
    }
}