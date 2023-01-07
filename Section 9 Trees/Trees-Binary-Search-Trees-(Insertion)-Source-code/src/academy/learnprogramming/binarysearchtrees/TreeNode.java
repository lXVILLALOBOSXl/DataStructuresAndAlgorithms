package academy.learnprogramming.binarysearchtrees;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void insert(int value) {
        if(this.data == value){
            return;
        }

        if(value < this.data) {
            if(this.leftChild == null) {
                this.leftChild = new TreeNode(value);
                return;
            }
            this.leftChild.insert(value);
            return;
        }

        if(this.rightChild == null) {
            this.rightChild = new TreeNode(value);
            return;
        }
        this.rightChild.insert(value);
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
