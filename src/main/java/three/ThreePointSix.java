package three;

import java.util.Stack;

public class ThreePointSix {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(6);
        s.push(2);
        s.push(7);
        s.push(5);
        s.push(1);

        StackSorter sorter = new StackSorter();
        Stack<Integer> sorted = sorter.sort(s);

        while(!sorted.isEmpty()) {
            System.out.println(sorted.pop());
        }
    }
}

class StackSorter {
    public Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> tempStack = new Stack<>();

        while(!s.isEmpty()) {
            int val = s.pop();
            put(val, tempStack);
        }

        while(!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return s;
    }

    private void put(int val, Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(val);
            return;
        }

        if(val > stack.peek()) {
            int smallVal = stack.pop();
            put(val, stack);
            stack.push(smallVal);
        } else if(val <= stack.peek()) {
            stack.push(val);
        }
    }
}
