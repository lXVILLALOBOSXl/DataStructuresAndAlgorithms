package academy.learnprogramming.maxheaps;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        this.heap = new int[capacity];
    }

    public void insert(int value){
        if(this.isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }

        this.heap[size] = value;
        this.fixHeapAbove(size);
        size++;
    }

    public int peek(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return this.heap[0];
    }

    public int delete(int index){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = this.getParent(index);
        int deletedValue = this.heap[index];
        //The rightmost node in the heap (the last in be added) will be our replacement value
        this.heap[index] = this.heap[size - 1];

        // If the rplacement value was the root or is less than its parent, it has to look down
        if(index == 0 || this.heap[index] < this.heap[parent]){
            this.fixHeapBelow(index, this.size - 1);
        }else {
            this.fixHeapAbove(index);
        }

        size--;
        return deletedValue;
    }

    private void fixHeapAbove(int index){
        int newValue = this.heap[index];
        while (index > 0 && newValue > this.heap[this.getParent(index)]){
            this.heap[index] = this.heap[this.getParent(index)];
            index = this.getParent(index);
        }
        this.heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = this.getChild(index, true);
            int rightChild = this.getChild(index, false);
            if(leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = ((this.heap[leftChild] > this.heap[rightChild]) ? leftChild : rightChild);
                }

                if (this.heap[index] < this.heap[childToSwap]) {
                    int tmp = this.heap[index];
                    this.heap[index] = this.heap[childToSwap];
                    this.heap[childToSwap] = tmp;
                }else {
                    break;
                }

                index = childToSwap;
            }else{
                break;
            }
        }
    }

    public void print(){
        System.out.print("[ ");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.heap[i] + ", ");
        }
        System.out.println("]");
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean left){
        return (2 * index) + (left ? 1 : 2);
    }

    public boolean isFull(){
        return this.size == this.heap.length;
    }

    public boolean isEmpty(){return this.size == 0;}

}
