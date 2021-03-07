package three;

public class ThreePointOne {

    public static void main(String[] args) {
        int[][] input = {
                {1,2,3,4},
                {8,7,6,5},
                {1,5,7,9}
        };
        MyStack stack = new MyStack();

        for(int i=0; i <3; i++) {
            for(int j=0; j<4; j++) {
                stack.push(input[i][j], i);
            }
        }
    }

}
class MyStack {
    int[] stack = new int[12];
    int[] pointer = {-1, 3, 7};

    public void push(int val, int index) {
        pointer[index] = pointer[index] + 1;
        stack[pointer[index]] = val;
    }

    public int pop(int index) {
        int res = stack[pointer[index]];
        pointer[index] = pointer[index] - 1;
        return res;
    }

    public void print() {
        for(int i=0; i< 12; i++) {
            System.out.println(stack[i]);
        }

    }
}
