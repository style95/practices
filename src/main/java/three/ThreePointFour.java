package three;

import java.util.Stack;

public class ThreePointFour {
    public static void main(String[] args) {
        Tower[] towers = {
            new Tower(),
            new Tower(),
            new Tower()
        };

        for(int i=5; i>0; i--) {
            towers[0].add(i);
        }

        //print(towers);

        towers[0].moveDisks(5, towers[2], towers[1]);

        print(towers);

    }

    public static void print(Tower[] towers) {
        int length = towers.length;
        for(int i=0; i< length; i++) {
            System.out.println("Tower " + i);
            if(towers[i].stack.empty()) {
                continue;
            }
            while(!towers[i].stack.isEmpty()) {
                System.out.println(towers[i].stack.pop());
            }
        }
    }

}

class Tower {
    Stack<Integer> stack = new Stack<>();

    public void moveTop(Tower dest) {
        int val = stack.pop();
        dest.add(val);
    }

    public void add(int val) {
        stack.push(val);
    }

    public void moveDisks(int n, Tower dest, Tower buffer) {
        if(n > 0) {
            moveDisks(n-1, buffer, dest);
            moveTop(dest);
            buffer.moveDisks(n-1, dest, this);
        }
    }
}
