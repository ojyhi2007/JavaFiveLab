import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public static Queue<Integer> reverseQueue(Queue<Integer> l1) {
        if (l1 == null) {
            throw new IllegalArgumentException("Очередь L1 не должна быть null");
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> l2 = new LinkedList<>();

        while (!l1.isEmpty()) {
            stack.push(l1.poll());
        }

        while (!stack.isEmpty()) {
            l2.offer(stack.pop());
        }

        return l2;
    }
}