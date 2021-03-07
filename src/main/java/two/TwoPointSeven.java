package two;

import java.util.Stack;

public class TwoPointSeven {
    public static void main(String[] args) {
        int[] input1 = {1,2,3,2,1,1};

        LinkedList l1 = new LinkedList(input1[0]);
        LinkedList n = l1;
        for(int i=1; i< input1.length; i++) {
            n.next = new LinkedList(input1[i]);
            n = n.next;
        }

        Palindrome p = new Palindrome();
        Boolean result = p.check(l1, 4);

       System.out.println(result);
    }
}

class Palindrome {
    public boolean check(LinkedList l, int middle) {
        LinkedList head = l;
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i < middle; i++) {
            stack.push(head.val);
            head = head.next;
        }

        if(middle % 2 == 1) {
            head = head.next;
        }

        while(head != null) {
            int temp = stack.pop();
            if(head.val != temp) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
