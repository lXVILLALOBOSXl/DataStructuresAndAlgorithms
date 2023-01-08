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

    private void fixHeapAbove(int index){
        int newValue = this.heap[index];
        while (index > 0 && newValue > this.heap[this.getParent(index)]){
            this.heap[index] = this.heap[this.getParent(index)];
            index = this.getParent(index);
        }
        this.heap[index] = newValue;
    }

    public boolean isFull(){
        return this.size == this.heap.length;
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }
}
