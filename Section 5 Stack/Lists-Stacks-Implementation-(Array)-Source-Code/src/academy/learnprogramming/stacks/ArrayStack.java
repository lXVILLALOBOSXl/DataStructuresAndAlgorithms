package academy.learnprogramming.stacks;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(int size) {
        this.stack = new Employee[size];
    }

    public void push(Employee employee) {

        if(this.top == this.stack.length){

            //Need to resize the backijng array
            Employee[] newArray = new Employee[2 * this.stack.length];
            System.arraycopy(this.stack,0,newArray,0,this.stack.length);
            this.stack = newArray;
        }

        this.stack[this.top++] = employee;
    }

    public Employee pop() {

        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        Employee employee = this.stack[--this.top];
        this.stack[this.top] = null;
        return employee;

    }

    public Employee peek() {

        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        return this.stack[this.top - 1];
    }

    public int size() {
        return this.top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void print(){

        for (int i = this.top - 1; i > -1; i--) {
            System.out.println(this.stack[i]);
        }
    }
}
