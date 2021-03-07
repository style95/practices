package two;

import java.util.HashSet;

public class TwoPointOne {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,2,1,5,5,10};

        LinkedList head = new LinkedList(input[0]);
        LinkedList n = head;
        for(int i=1; i< input.length; i++) {
            n.next = new LinkedList(input[i]);
            n = n.next;
        }

        print(head);

        Duplicate d = new Duplicate();
        d.removeDuplicate(head);

        print(head);
    }

    public static void print(LinkedList l) {
        LinkedList n = l;
        System.out.println(n.val);

        while(n.next != null) {
            System.out.println(n.next.val);
            n = n.next;
        }
        System.out.println();
    }
}

class LinkedList {
    int val;
    LinkedList next;

    public LinkedList(int value) {
        this.val = value;
    }
}


class Duplicate {
    public void removeDuplicate(LinkedList l) {
        HashSet<Integer> set = new HashSet<>();
        set.add(l.val);
        while(l.next != null) {
            if(set.contains(l.next.val)) {
                l.next = l.next.next;
            } else {
                set.add(l.next.val);
                l = l.next;
            }
        }
    }
}
