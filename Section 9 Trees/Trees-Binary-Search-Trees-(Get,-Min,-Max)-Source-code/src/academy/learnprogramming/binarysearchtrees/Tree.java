package academy.learnprogramming.binarysearchtrees;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
            return;
        }
        this.root.insert(value);
    }

    public TreeNode get(int value){
        if(this.root != null){
            return this.root.get(value);
        }
        return null;
    }

    public int min(){
        if(this.root != null){
            return this.root.min();
        }
        return Integer.MIN_VALUE;
    }

    public int max(){
        if(this.root != null){
            return this.root.max();
        }
        return Integer.MAX_VALUE;
    }

    public void traverseInOrder() {
        if (this.root != null) {
            this.root.traverseInOrder();
        }
    }

}
