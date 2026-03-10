import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Выберите задание: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runTask1();
                    break;
                case "2":
                    runTask2();
                    break;
                case "3":
                    runTask3();
                    break;
                case "4":
                    runTask4();
                    break;
                case "5":
                    runTask5();
                    break;
                case "6":
                    runTask6();
                    break;
                case "7.1":
                    runTask71();
                    break;
                case "7.2":
                    runTask72();
                    break;
                case "0":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неверный пункт меню.");
            }

            System.out.println();
            System.out.println("Нажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        }
    }

    private static void printMenu() {
        System.out.println("========== Лабораторная работа 5, вариант 9 ==========");
        System.out.println("1   - Задание 1. Шаблоны (Дробь)");
        System.out.println("2   - Задание 2. Структурные шаблоны (Кот)");
        System.out.println("3   - Задание 3. Список");
        System.out.println("4   - Задание 4. Map");
        System.out.println("5   - Задание 5. Set");
        System.out.println("6   - Задание 6. Queue");
        System.out.println("7.1 - Задание 7.1. Stream (Point -> Polyline)");
        System.out.println("7.2 - Задание 7.2. Stream (People)");
        System.out.println("0   - Выход");
        System.out.println("======================================================");
    }

    private static void runTask1() {
        System.out.println("Задание 1 — Дробь");
        System.out.println();

        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(-5, -8);
        Fraction f3 = new Fraction(2, -7);

        System.out.println("Обычные дроби:");
        System.out.println(f1 + " = " + f1.toDouble());
        System.out.println(f2 + " = " + f2.toDouble());
        System.out.println(f3 + " = " + f3.toDouble());

        System.out.println();
        System.out.println("Проверка equals:");
        System.out.println("Fraction(1,2) equals Fraction(1,2): "
                + new Fraction(1, 2).equals(new Fraction(1, 2)));
        System.out.println("Fraction(1,2) equals Fraction(2,4): "
                + new Fraction(1, 2).equals(new Fraction(2, 4)));

        System.out.println();
        System.out.println("Кэшируемая дробь:");
        CachedFraction cf = new CachedFraction(7, 8);

        System.out.println("cf = " + cf);
        System.out.println("Первый вызов toDouble(): " + cf.toDouble());
        System.out.println("Второй вызов toDouble(): " + cf.toDouble());

        cf.setNumerator(3);
        System.out.println("После изменения числителя:");
        System.out.println("cf = " + cf);
        System.out.println("toDouble() = " + cf.toDouble());
    }

    private static void runTask2() {
        System.out.println("Задание 2 — Количество мяуканий");
        System.out.println();

        Cat cat = new Cat("Барсик");
        MeowCounter countedCat = new MeowCounter(cat);

        System.out.println("До вызова метода:");
        System.out.println("Кот: " + cat);
        System.out.println("Количество мяуканий: " + countedCat.getMeowCount());

        System.out.println();
        MeowService.meowAll(countedCat, countedCat, countedCat);

        System.out.println();
        System.out.println("После вызова метода:");
        System.out.println("Кот: " + cat);
        System.out.println("Количество мяуканий: " + countedCat.getMeowCount());
    }

    private static void runTask3() {
        System.out.println("Задание 3 — Список");
        System.out.println();

        List<Integer> l1 = List.of(5, 1, 5, 2, 3, 2, 4, 6, 6);
        List<Integer> l2 = List.of(2, 4, 7);

        List<Integer> l = ListDifference.buildList(l1, l2);

        System.out.println("L1 = " + l1);
        System.out.println("L2 = " + l2);
        System.out.println("L  = " + l);
    }

    private static void runTask4() throws IOException {
        System.out.println("Задание 4 — Map");
        System.out.println();

        List<StudentResult> students = SchoolStatistics.readStudentsFromFile("src/students.txt");

        System.out.println("Ученики:");
        for (StudentResult student : students) {
            System.out.println(student);
        }

        double districtAverage = SchoolStatistics.findDistrictAverage(students);
        Map<Integer, Double> schoolAverages = SchoolStatistics.findSchoolAverages(students);
        List<Integer> schoolsAboveAverage = SchoolStatistics.findSchoolsAboveDistrictAverage(students);

        System.out.println();
        System.out.println("Средний балл по району: " + districtAverage);

        System.out.println("Средний балл по школам:");
        for (Map.Entry<Integer, Double> entry : schoolAverages.entrySet()) {
            System.out.println("Школа " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Школы, где средний балл выше районного: " + schoolsAboveAverage);
    }

    private static void runTask5() throws IOException {
        System.out.println("Задание 5 — Set");
        System.out.println();

        String text = UniqueWordSymbols.readTextFromFile("src/text.txt");
        Set<Character> chars = UniqueWordSymbols.findCharsInOnlyOneWord(text);

        System.out.println("Текст:");
        System.out.println(text);

        System.out.println();
        System.out.println("Символы, которые встречаются только в одном слове:");
        System.out.println(chars);
    }

    private static void runTask6() {
        System.out.println("Задание 6 — Очередь");
        System.out.println();

        Queue<Integer> l1 = new LinkedList<>();
        l1.offer(1);
        l1.offer(2);
        l1.offer(3);
        l1.offer(4);
        l1.offer(5);

        System.out.println("L1 = " + l1);

        Queue<Integer> l2 = QueueReverser.reverseQueue(new LinkedList<>(l1));

        System.out.println("L2 = " + l2);
    }

    private static void runTask71() {
        System.out.println("Задание 7.1 — Stream (Point -> Polyline)");
        System.out.println();

        List<Point> points = List.of(
                new Point(5, -2),
                new Point(1, 4),
                new Point(3, -7),
                new Point(1, 4),
                new Point(2, -5),
                new Point(5, -2),
                new Point(4, 8)
        );

        System.out.println("Исходные точки: " + points);

        Polyline polyline = PolylineStream.buildPolyline(points);

        System.out.println("Ломаная: " + polyline);
    }

    private static void runTask72() throws IOException {
        System.out.println("Задание 7.2 — Stream (People)");
        System.out.println();

        Map<Integer, List<String>> groupedPeople = PeopleStream.groupPeople("src/people.txt");

        System.out.println("Люди по номеру:");
        System.out.println(groupedPeople);
    }
}