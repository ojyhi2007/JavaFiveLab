public class StudentResult {

    private String surname;
    private String name;
    private int school;
    private int score;

    public StudentResult(String surname, String name, int school, int score) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Фамилия не должна быть пустой");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        if (school < 1 || school > 99) {
            throw new IllegalArgumentException("Номер школы должен быть в диапазоне 1..99");
        }
        if (score < 1 || score > 100) {
            throw new IllegalArgumentException("Балл должен быть в диапазоне 1..100");
        }

        this.surname = surname;
        this.name = name;
        this.school = school;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getSchool() {
        return school;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + school + " " + score;
    }
}