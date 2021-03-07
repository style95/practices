package three;

import java.util.ArrayList;
import java.util.Stack;

public class ThreePointThree {
    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks();
        for(int i=0; i<3; i++) {
            for(int j=0; j<5; j++) {
                  stacks.push(i);
            }
        }

        System.out.println("size: " + stacks.size());

        for(int i=0; i<3; i++) {
            for(int j=0; j<5; j++) {
                System.out.println("poped: " +stacks.pop());
                System.out.println("size: " + stacks.size());
            }
        }

    }
}

class SetOfStacks {
    int STACK_SIZE = 5;
    ArrayList<Stack<Integer>> list = new ArrayList<>();

    private void addNewStack() {
        Stack<Integer> stack = new Stack();
        list.add(stack);
    }

    public void push(int val) {
        if(list.size() == 0) {
            addNewStack();
        }

        int last = list.size() - 1;
        Stack<Integer> lastStack = list.get(last);
        if(lastStack.size() == STACK_SIZE) {
            addNewStack();
            list.get(last + 1).push(val);
            return;
        }
        list.get(last).push(val);
    }

    public int pop() {
        int index = list.size();
        Stack<Integer> lastStack = list.get(index - 1);
        if(lastStack.empty()) {
            int res = list.get(index - 2).pop();
            list.remove(index - 1);
            return res;
        }
        return lastStack.pop();
    }

    public int size() {
        return list.size();
    }
}
