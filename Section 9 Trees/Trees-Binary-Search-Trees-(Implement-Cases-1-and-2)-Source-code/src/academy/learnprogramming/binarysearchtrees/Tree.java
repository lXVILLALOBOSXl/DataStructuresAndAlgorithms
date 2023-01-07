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

    public void delete(int value){
        this.root = delete(this.root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value){
        if(subtreeRoot == null){
            return subtreeRoot;
        }

        if(value < subtreeRoot.getData()){
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(),value));
        }else if(value > subtreeRoot.getData()){
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),value));
        }else{
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if(subtreeRoot.getLeftChild() == null){
                return subtreeRoot.getRightChild();
            }else if(subtreeRoot.getRightChild() == null){
                return subtreeRoot.getLeftChild();
            }
        }

        return subtreeRoot;
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
