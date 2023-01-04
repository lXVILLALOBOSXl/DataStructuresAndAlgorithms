package academy.learnprogramming.stacks;

public class Main {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Luis", "Villalobos", 1));
        stack.push(new Employee("Adrian", "Rivera", 2));
        stack.push(new Employee("Angel", "Leonardo", 3));
        stack.push(new Employee("Ceci", "Alarcon", 4));
        stack.push(new Employee("Jorge", "Reynoso", 5));

        //stack.print();

        System.out.println(stack.peek());
        //stack.print();

        System.out.println("Popped: " + stack.pop());
        System.out.println(stack.peek());


    }
}
