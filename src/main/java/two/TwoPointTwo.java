package two;

public class TwoPointTwo {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,2,7,8,9,10};

        LinkedList head = new LinkedList(input[0]);
        LinkedList n = head;
        for(int i=1; i< input.length; i++) {
            n.next = new LinkedList(input[i]);
            n = n.next;
        }

        print(head);

        Finder f = new Finder();
        LinkedList result = f.find(head, 3);

        System.out.println(result.val);
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


class Finder {
    public LinkedList find(LinkedList l, int k) {
        if(l == null) {
            return null;
        }
        if(k < 0) {
            return null;
        }
        LinkedList p1 = l;
        LinkedList p2 = l;
        int count = 0;
        while(p1 != null) {
            if(count >= k) {
                p2 = p2.next;
            }
            count++;
            p1 = p1.next;
        }
        if(count <= k) {
            return null;
        }
        return p2;
    }
}
