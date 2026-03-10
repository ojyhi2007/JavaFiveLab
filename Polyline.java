import java.util.ArrayList;
import java.util.List;

public class Polyline {

    private List<Point> points;

    public Polyline(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("Список точек не должен быть null");
        }
        this.points = new ArrayList<>(points);
    }

    @Override
    public String toString() {
        return "Ломаная " + points;
    }
}