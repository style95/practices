package four;

class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.val = value;
    }

    public void setLeft(TreeNode<T> t) {
        this.left = t;
    }

    public void setRight(TreeNode<T> t) {
        this.right = t;
    }

    public void print() {
        printTree(this);
    }

    private void printTree(TreeNode<T> t) {
        if(t != null) {
            System.out.println(t.val);
            printTree(t.left);
            printTree(t.right);
        }
    }

}
