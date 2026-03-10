public class MeowCounter implements Meowable {

    private Cat cat;
    private int meowCount;

    public MeowCounter(Cat cat) {
        if (cat == null) {
            throw new IllegalArgumentException("Кот не должен быть null");
        }
        this.cat = cat;
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        meowCount++;
        cat.meow();
    }

    public int getMeowCount() {
        return meowCount;
    }

    public Cat getCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Счетчик мяуканий для " + cat + ": " + meowCount;
    }
}