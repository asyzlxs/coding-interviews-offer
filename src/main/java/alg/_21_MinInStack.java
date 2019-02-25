package alg;

import java.util.Stack;

public class _21_MinInStack {
    Stack<Integer> m_data = new Stack<>();
    Stack<Integer> m_min = new Stack<>();

    public void push(int node) {
        m_data.push(node);
        if (m_min.isEmpty()) {
            m_min.push(node);
        } else {
            m_min.push(Math.min(m_min.peek(), node));
        }
    }

    public int pop() {
        m_min.pop();
        return m_data.pop();
    }

    public int min() {
        return m_min.peek();
    }

    public int peek() {
        return m_data.peek();
    }


}
