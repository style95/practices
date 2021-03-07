package four;

import java.util.Arrays;

public class FourPointThree {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};

        TreeMaker maker = new TreeMaker();
        TreeNode<Integer> t = maker.make(input);

        t.printBFS();
    }

}

class TreeMaker {
    public TreeNode<Integer> make(int[] input) {
        TreeNode n = new TreeNode<Integer>(null);
        TreeNode<Integer> t = makeSubTree(input, n);

        return t;
    }

    private TreeNode<Integer> makeSubTree(int[] input, TreeNode<Integer> t) {
        if(input.length == 0) {
            return t;
        }
        int middle = input.length / 2;
        t.val = input[middle];

        if(input.length == 1) {
            return t;
        }

        if(middle > 0) {
            int[] leftInput = Arrays.copyOfRange(input, 0, middle);
            t.left = new TreeNode<Integer>(null);
            makeSubTree(leftInput, t.left);
        }

        if(middle + 1 <= input.length -1) {
            int[] rightInput = Arrays.copyOfRange(input, middle + 1, input.length);
            t.right = new TreeNode<Integer>(null);
            makeSubTree(rightInput, t.right);
        }

        return t;
    }
}
