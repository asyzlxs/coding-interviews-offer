package alg;

import java.util.Stack;

public class _07_QueryWithTwoStacks {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    private int N = 0;

    public void appendTail(int val) {
        stack1.push(val);
        ++N;
    }

    public int deleteHead() {
        if (N == 0)
            return -1;
        if (!stack2.isEmpty()) {
            --N;
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
    }

    public static void main(String[] args) {
        _07_QueryWithTwoStacks query = new _07_QueryWithTwoStacks();
        for (int i = 0; i < 5; i++) {

        }
    }


}
