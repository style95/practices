package three;

import java.util.Stack;

public class ThreePointTwo {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.push(7);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }
}


class MinStack {
    int[] stack = new int[10];
    int pointer = -1;
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if( min() > val) {
            minStack.push(val);
        }
        pointer++;
        stack[pointer] = val;
    }

    public int pop() {
        int res = stack[pointer--];
        if(res == min()) {
            minStack.pop();
        }
        return res;
    }

    public int min() {
        if(minStack.empty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
