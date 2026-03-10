import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListTask {

    public static List<Integer> buildList(List<Integer> l1, List<Integer> l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Списки не должны быть null");
        }

        Set<Integer> result = new LinkedHashSet<>();

        for (Integer element : l1) {
            if (!l2.contains(element)) {
                result.add(element);
            }
        }

        return new ArrayList<>(result);
    }
}