package two;

public class TwoPointFiveDashTwo {
    public static void main(String[] args) {
        int[] input1 = {7,1,6,9};
        int[] input2 = {5,9,2};

        LinkedList l1 = new LinkedList(input1[0]);
        LinkedList n = l1;
        for(int i=1; i< input1.length; i++) {
            n.next = new LinkedList(input1[i]);
            n = n.next;
        }

        LinkedList l2 = new LinkedList(input2[0]);
        LinkedList n2 = l2;
        for(int i=1; i< input2.length; i++) {
            n2.next = new LinkedList(input2[i]);
            n2 = n2.next;
        }

        ReverseAdder adder = new ReverseAdder();
        LinkedList result = adder.sum(l1, l2);

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

class ReverseAdder {
    public LinkedList sum(LinkedList l1, LinkedList l2) {
        if(l1 == null  && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        LinkedList p1 = l1;
        LinkedList p2 = l2;
        int size1 = this.length(p1);
        int size2 = this.length(p2);
        if(size1 > size2) {
            p2 = this.addPadding(p2, size1 - size2);
        }
        if(size2 > size1) {
            p1 = this.addPadding(p1, size2 - size1);
        }
        LinkedList head = this.sumR(p1, p2, null);
        if(head.val >= 10) {
            head.val = head.val % 10;
            LinkedList temp = new LinkedList(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    private LinkedList sumR(LinkedList l1, LinkedList l2, LinkedList h) {
        if(l1.next == null || l2.next == null) {
            return this.insertHead(h, l1.val + l2.val);
        } else {
            LinkedList head = this.sumR(l1.next, l2.next, h);
            int carry = 0;
            if(head.val >= 10) {
                head.val = head.val % 10;
                carry = 1;
            }
            int sum = l1.val + l2.val + carry;
            return this.insertHead(head, sum);
        }
    }

    private LinkedList insertHead(LinkedList head, int value) {
        if(head == null) {
            head = new LinkedList(value);
            return head;
        } else {
            LinkedList newNode = new LinkedList(value);
            newNode.next = head;
            return newNode;
        }
    }

    private int length(LinkedList l) {
        LinkedList p = l;
        int count = 0;
        while(p!= null) {
            count++;
            p = p.next;
        }
        return count;
    }

    private LinkedList addPadding(LinkedList l, int size) {
        LinkedList head = l;
        for(int i=size; i>0; i--) {
            LinkedList temp = new LinkedList(0);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
