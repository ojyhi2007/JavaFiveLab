import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SchoolMapTask {

    public static List<StudentResult> readStudentsFromFile(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        List<StudentResult> students = new ArrayList<>();

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Файл пустой");
        }

        int n = Integer.parseInt(lines.get(0).trim());

        if (n < 5) {
            throw new IllegalArgumentException("По условию должно быть не менее 5 учеников");
        }

        if (lines.size() - 1 < n) {
            throw new IllegalArgumentException("В файле меньше строк с учениками, чем указано в первой строке");
        }

        for (int i = 1; i <= n; i++) {
            String line = lines.get(i).trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts.length != 4) {
                throw new IllegalArgumentException("Некорректная строка: " + line);
            }

            String surname = parts[0];
            String name = parts[1];
            int school = Integer.parseInt(parts[2]);
            int score = Integer.parseInt(parts[3]);

            students.add(new StudentResult(surname, name, school, score));
        }

        return students;
    }

    public static double findDistrictAverage(List<StudentResult> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Список учеников не должен быть пустым");
        }

        int totalScore = 0;

        for (StudentResult student : students) {
            totalScore += student.getScore();
        }

        return (double) totalScore / students.size();
    }

    public static Map<Integer, Double> findSchoolAverages(List<StudentResult> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Список учеников не должен быть пустым");
        }

        Map<Integer, Integer> sumBySchool = new TreeMap<>();
        Map<Integer, Integer> countBySchool = new TreeMap<>();

        for (StudentResult student : students) {
            int school = student.getSchool();
            int score = student.getScore();

            sumBySchool.put(school, sumBySchool.getOrDefault(school, 0) + score);
            countBySchool.put(school, countBySchool.getOrDefault(school, 0) + 1);
        }

        Map<Integer, Double> averageBySchool = new TreeMap<>();

        for (Integer school : sumBySchool.keySet()) {
            double average = (double) sumBySchool.get(school) / countBySchool.get(school);
            averageBySchool.put(school, average);
        }

        return averageBySchool;
    }

    public static List<Integer> findSchoolsAboveDistrictAverage(List<StudentResult> students) {
        double districtAverage = findDistrictAverage(students);
        Map<Integer, Double> schoolAverages = findSchoolAverages(students);

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Double> entry : schoolAverages.entrySet()) {
            if (entry.getValue() > districtAverage) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}