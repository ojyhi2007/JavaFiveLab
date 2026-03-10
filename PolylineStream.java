import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PolylineStream {

    public static Polyline buildPolyline(List<Point> points) {

        if (points == null) {
            throw new IllegalArgumentException("Список точек не должен быть null");
        }

        List<Point> result = points.stream()
                .filter(p -> p != null)
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());

        return new Polyline(result);
    }
}