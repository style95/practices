package four;

public class FourPointOne {
    public static void main(String[] args) {
        TreeNode<Integer> t = new TreeNode<>(1);
        TreeNode<Integer> c1 = new TreeNode<>(2);
        TreeNode<Integer> c2 = new TreeNode<>(3);

        TreeNode<Integer> c11 = new TreeNode<>(4);
        TreeNode<Integer> c12 = new TreeNode<>(5);

        TreeNode<Integer> c21 = new TreeNode<>(6);
        TreeNode<Integer> c22 = new TreeNode<>(7);

        t.setLeft(c1);
        t.setRight(c2);

        c1.setLeft(c11);
        c1.setRight(c12);

        c11.setLeft(c21);
        c11.setRight(c22);

        t.print();

        BalanceChecker<Integer> checker = new BalanceChecker<>();

        System.out.println(checker.check(t));

    }
}

class BalanceChecker<T> {
    public boolean check(TreeNode<T> t) {
        int leftH = getHeight(0, t.left);
        int rightH = getHeight(0, t.right);

        if(Math.abs(leftH - rightH) >= 2) {
            return false;
        }
        return true;
    }

    private int getHeight(int height, TreeNode<T> t) {
        if(t == null) {
            return height;
        }
        return Math.max(getHeight(height + 1, t.left), getHeight(height +1, t.right));
    }


}
