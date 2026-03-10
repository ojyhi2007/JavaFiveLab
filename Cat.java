public class Cat {

    private String name;

    public Cat(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя кота не должно быть пустым");
        }
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}