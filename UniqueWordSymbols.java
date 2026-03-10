import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWordSymbols {

    public static String readTextFromFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    public static Set<Character> findCharsInOnlyOneWord(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Текст не должен быть пустым");
        }

        Map<Character, Integer> charWordCount = new HashMap<>();

        String[] words = text.toLowerCase().split("[^а-яёa-z0-9]+");

        for (String word : words) {
            if (word.isBlank()) {
                continue;
            }

            Set<Character> uniqueCharsInWord = new HashSet<>();

            for (int i = 0; i < word.length(); i++) {
                uniqueCharsInWord.add(word.charAt(i));
            }

            for (Character ch : uniqueCharsInWord) {
                charWordCount.put(ch, charWordCount.getOrDefault(ch, 0) + 1);
            }
        }

        Set<Character> result = new TreeSet<>();

        for (Map.Entry<Character, Integer> entry : charWordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}