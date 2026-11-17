
import java.util.*;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {

        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {

        int removed = stack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class code {

    public static void main(String[] args) {

        MinStack stk = new MinStack();

        stk.push(-2);
        stk.push(0);
        stk.push(-3);

        System.out.println("Minimum: " + stk.getMin());

        stk.pop();

        System.out.println("Top Element: " + stk.top());

        System.out.println("Minimum: " + stk.getMin());
    }
}
