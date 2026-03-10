import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleStream {

    public static Map<Integer, List<String>> groupPeople(String fileName) throws IOException {

        return Files.lines(Path.of(fileName))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(":", -1))
                .filter(parts -> parts.length == 2 && !parts[1].isBlank())
                .map(parts -> Map.entry(
                        Integer.parseInt(parts[1].trim()),
                        normalizeName(parts[0].trim())
                ))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        java.util.TreeMap::new,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }

    private static String normalizeName(String name) {

        String lower = name.toLowerCase();

        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}