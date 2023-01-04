package academy.learnprogramming.queues;

import java.util.NoSuchElementException;

public class ArrayQueue {

   private Employee[] queue;
   private int front;
   private int back;

    public ArrayQueue(int size) {
        this.queue = new Employee[size];
    }

    public void add(Employee employee) {

        if(this.back == this.queue.length){

            Employee[] newArray = new Employee[2 * this.queue.length];
            System.arraycopy(this.queue,0,newArray,0,this.queue.length);
            this.queue = newArray;
        }

        this.queue[back++] = employee;
    }

    public Employee remove() {

        if(isEmpty()){

            throw new NoSuchElementException();
        }

        Employee employee = this.queue[front];
        this.queue[front++] = null;

        if(isEmpty()){

            this.back = 0;
            this.front = 1;
        }

        return employee;
    }

    public Employee peek(){

        if(isEmpty()){

            throw new NoSuchElementException();
        }

        return this.queue[front];
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return back - front;
    }

    public void print(){

        for (int i = this.front; i < this.back; i++) {

            System.out.println(this.queue[i]);
        }
    }
}
