package academy.learnprogramming.binarysearchtrees;

public class Tree {

    public TreeNode root;

    public void insert(int value) {
        if(this.root == null){
            this.root = new TreeNode(value);
            return;
        }
        this.root.insert(value);
    }
}
