package two;

public class TwoPointFive {
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

        Adder adder = new Adder();
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


class Adder {
    public LinkedList sum(LinkedList l1, LinkedList l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }


        LinkedList head = null;
        LinkedList current = null;
        int carry = 0;

        while(l1 != null && l2 != null) {
            TwoPointFive.print(l1);
            TwoPointFive.print(l2);
            if(head == null) {
                int sum = l1.val + l2.val + carry;
                if(sum >= 10) {
                    head = new LinkedList(sum % 10);
                    current = head;
                    carry = 1;
                } else {
                    head = new LinkedList(sum);
                    current = head;
                }
            } else {
                int sum = l1.val + l2.val + carry;
                if(sum >= 10) {
                    current.next = new LinkedList(sum % 10);
                    current = current.next;
                    carry = 1;
                } else {
                    current.next = new LinkedList(sum);
                    current = current.next;
                    carry = 1;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 != null) {
            while(l1 != null) {
                int sum = l1.val + carry;
                if( sum >= 10) {
                    current.next = new LinkedList(sum % 10);
                    carry = 1;
                    current = current.next;
                } else {
                    current.next = new LinkedList(sum % 10);
                    carry = 0;
                    current = current.next;
                }
                l1 = l1.next;
            }
        }

        if(l2 != null) {
            while(l2 != null) {
                int sum = l2.val + carry;
                if( sum >= 10) {
                    current.next = new LinkedList(sum % 10);
                    carry = 1;
                    current = current.next;
                } else {
                    current.next = new LinkedList(sum % 10);
                    carry = 0;
                    current = current.next;
                }
                l2 = l2.next;
            }
        }

        if(carry > 0) {
            current.next = new LinkedList(carry);
        }
        return head;
    }
}
