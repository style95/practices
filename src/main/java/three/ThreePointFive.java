package three;

import java.util.Stack;

public class ThreePointFive {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        myQueue.push(6);
        myQueue.push(7);
        myQueue.push(8);
        myQueue.push(9);
        myQueue.push(10);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        myQueue.push(11);
        myQueue.push(12);
        myQueue.push(13);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }
}

class MyQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void push(int val) {
        pushStack.push(val);
    }

    public int pop() {
        if(popStack.size() == 0) {
            while(pushStack.size() > 0) {
                int temp = pushStack.pop();
                popStack.push(temp);
            }
        }
        return popStack.pop();
    }
    public int size() {
        return pushStack.size() + popStack.size();
    }
}
