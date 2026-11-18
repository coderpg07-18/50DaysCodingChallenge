
import java.util.*;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        moveElements();
        return out.pop();
    }

    public int peek() {
        moveElements();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void moveElements() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}

public class code {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("Front Element: " + queue.peek());

        System.out.println("Removed Element: " + queue.pop());

        System.out.println("Front Element: " + queue.peek());

        System.out.println("Is Queue Empty? " + queue.empty());

        queue.pop();
        queue.pop();

        System.out.println("Is Queue Empty? " + queue.empty());
    }
}
