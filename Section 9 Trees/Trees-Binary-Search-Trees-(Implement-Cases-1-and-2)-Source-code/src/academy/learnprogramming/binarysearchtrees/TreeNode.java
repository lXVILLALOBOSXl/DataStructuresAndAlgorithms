package academy.learnprogramming.binarysearchtrees;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == this.data) {
            return;
        }

        if (value < this.data) {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(value);
                return;
            }
            this.leftChild.insert(value);
            return;
        }
        if (rightChild == null) {
            this.rightChild = new TreeNode(value);
            return;
        }
        this.rightChild.insert(value);
    }

    public TreeNode get(int value){
        if (value == this.data) {
            return this;
        }

        if (value < this.data) {
            if(this.leftChild != null) {
                return this.leftChild.get(value);
            }
        }

        if(this.rightChild != null){
            return this.rightChild.get(value);
        }

        return null;
    }

    public int min() {
        while (this.leftChild == null){
            return this.data;
        }
        return this.leftChild.min();
    }

    public int max() {
        while (this.rightChild == null){
            return this.data;
        }
        return this.rightChild.max();
    }
    public void traverseInOrder() {
        if (this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (this.rightChild != null) {
            this.rightChild.traverseInOrder();
        }
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

    public String toString() {
        return "Data = " + data;
    }
}
