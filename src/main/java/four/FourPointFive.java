package four;

public class FourPointFive {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode<>(10);
        TreeNode<Integer> t2 = new TreeNode<>(20);
        TreeNode<Integer> t3 = new TreeNode<>(30);
        TreeNode<Integer> t4 = new TreeNode<>(40);
        TreeNode<Integer> t5 = new TreeNode<>(25);
        TreeNode<Integer> t6 = new TreeNode<>(5);

        t2.left = t1;
        t1.right = t5;
        t2.right = t3;
        t3.right = t4;

        CheckBST checker = new CheckBST();

        System.out.println(checker.check(t2));

        t1.left = t6;
        t1.right = null;

        System.out.println(checker.check(t2));
    }
}

class CheckBST {
    public boolean check(TreeNode<Integer> t) {
        if (t == null) {
            return false;
        }

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        return checkValue(t, max, min);
    }

    private boolean checkValue(TreeNode<Integer> t, int max, int min) {
        if (t == null) {
            return true;
        }

        if (t.val > min && t.val <= max) {
            return checkValue(t.left, t.val, min) && checkValue(t.right, max, t.val);
        } else {
            return false;
        }
    }
}
