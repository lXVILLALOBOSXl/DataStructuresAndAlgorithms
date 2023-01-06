import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(Search.linear(array,-15));
        System.out.println(Search.linear(array,1));
        System.out.println(Search.linear(array,8888));
        System.out.println(Search.linear(array,-22));
        System.out.println("---------------------- ");
        System.out.println(Search.binaryIterative(array,-15));
        System.out.println(Search.binaryIterative(array,1));
        System.out.println(Search.binaryIterative(array,8888));
        System.out.println(Search.binaryIterative(array,-22));
        System.out.println("---------------------- ");
        System.out.println(Search.binaryIterative(array,-15));
        System.out.println(Search.binaryIterative(array,1));
        System.out.println(Search.binaryIterative(array,8888));
        System.out.println(Search.binaryIterative(array,-22));
    }
}
