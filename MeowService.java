public class MeowService {

    public static void meowAll(Meowable... meowables) {
        if (meowables == null) {
            throw new IllegalArgumentException("Набор мяукающих объектов не должен быть null");
        }

        for (Meowable meowable : meowables) {
            if (meowable != null) {
                meowable.meow();
            }
        }
    }
}