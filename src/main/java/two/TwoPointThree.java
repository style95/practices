package two;

public class TwoPointThree {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,2};

        LinkedList head = new LinkedList(input[0]);
        LinkedList n = head;
        for(int i=1; i< input.length; i++) {
            n.next = new LinkedList(input[i]);
            n = n.next;
        }

        LinkedList p = head.next.next.next.next;

        Remover r = new Remover();
        r.remove(p);

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

class Remover {
    public boolean remove(LinkedList p) {
        if(p == null || p.next == null) {
            return false;
        }
        p.val = p.next.val;
        p.next = p.next.next;

        return true;
    }
}
