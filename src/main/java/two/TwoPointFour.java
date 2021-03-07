package two;

public class TwoPointFour {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,2};

        LinkedList head = new LinkedList(input[0]);
        LinkedList n = head;
        for(int i=1; i< input.length; i++) {
            n.next = new LinkedList(input[i]);
            n = n.next;
        }

        Sorter s = new Sorter();
        LinkedList result = s.sort(head, 1);

        print(result);
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

class Sorter {
    public LinkedList sort(LinkedList l, int x) {
        LinkedList head = l;
        LinkedList front = null;
        LinkedList back = null;

        LinkedList frontHead = front; // null
        LinkedList backHead = back;	   // null

        while(head != null) {
            if(head.val < x) {
                if(front == null) {
                    front = new LinkedList(head.val);
                } else {
                    front.next = new LinkedList(head.val);
                    front = front.next;
                }
                if(frontHead == null && front != null) {
                    frontHead = front;
                }
            } else {
                if(back == null) {
                    back = new LinkedList(head.val);
                } else {
                    back.next = new LinkedList(head.val);
                    back = back.next;
                }
                if(backHead == null && back != null) {
                    backHead = back;
                }
            }
            head = head.next;
        }

        if(front != null) {
            front.next = backHead;
        } else {
            return backHead;
        }
        return frontHead;
    }
}
