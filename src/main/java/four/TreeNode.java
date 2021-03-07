package four;


import java.util.ArrayList;

class TreeNode<T> {
    T val;
    boolean visited = false;
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

    public void printDFS() {
        printTree(this);
    }

    private void printTree(TreeNode<T> t) {
        if(t != null) {
            System.out.println(t.val);
            printTree(t.left);
            printTree(t.right);
        }
    }

    public void printBFS() {
        ArrayList<PrintNode<T>> list = new ArrayList<>();
        PrintNode<T> p = new PrintNode<>();
        p.val = this.val;
        p.height = 1;
        list.add(p);

        searchTree(this, list, 2);

        printList(list);
    }

    private void searchTree(TreeNode<T> t, ArrayList<PrintNode<T>> l, int height) {
        if(t.left != null && t.right != null) {
            PrintNode<T> pl = new PrintNode<>();
            pl.val = t.left.val;
            pl.height = height;
            l.add(pl);

            PrintNode<T> pr = new PrintNode<>();
            pr.val = t.right.val;
            pr.height = height;
            l.add(pr);

            searchTree(t.left, l, height + 1);
            searchTree(t.right, l, height + 1);
        } else if(t.left != null) {
            PrintNode<T> pl = new PrintNode<>();
            pl.val = t.left.val;
            pl.height = height;
            l.add(pl);

            PrintNode<T> pr = new PrintNode<>();
            pr.val = null;
            pr.height = height;
            l.add(pr);

            searchTree(t.left, l, height + 1);
        } else if(t.right != null) {
            PrintNode<T> pl = new PrintNode<>();
            pl.val = null;
            pl.height = height;
            l.add(pl);

            PrintNode<T> pr = new PrintNode<>();
            pr.val = t.right.val;
            pr.height = height;
            l.add(pr);

            searchTree(t.right, l, height + 1);
        } else {
            return;
        }
    }
    private void printList(ArrayList<PrintNode<T>> l) {
        PrintNode<T> last = l.get(l.size() - 1);
        int height = last.height;

        for(int i = 0; i < l.size(); i++ ) {
            PrintNode temp = l.get(i);
            if(i == 0) {
                printPad(height - temp.height + 1);
            }
            if(i-1 >= 0 && temp.height != l.get(i - 1).height) {
                printPad(height - temp.height + 1);
            }

            if(temp.val != null) {
                System.out.print(temp.val + " ");
            } else {
                System.out.print(" ");
            }
            if(i + 1 < l.size() - 1 && temp.height != l.get(i + 1).height) {
                System.out.println();
            }
            if(i + 1 == l.size()) {
                System.out.println();
            }
        }
    }

    private void printPad(int length) {
        for(int i=0; i<length; i++) {
            System.out.print(" ");
        }
    }

    private class PrintNode<T> {
        T val;
        int height = 0;
    }

}
