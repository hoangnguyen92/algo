package problemsolver;

import java.util.Stack;

public class StackPractice {

    public void solve() {
        Stack<Character> stack = new Stack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        stack.push('E');
        stack.push('F');

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
