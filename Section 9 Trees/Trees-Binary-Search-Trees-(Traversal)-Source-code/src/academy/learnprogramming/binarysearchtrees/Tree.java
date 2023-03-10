package academy.learnprogramming.binarysearchtrees;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        root.insert(value);
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }


}
