import java.util.Arrays;

public final class Search {

    public static int linear(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if(input[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binaryIterative(int[] input, int value) {
        Arrays.sort(input);;
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midPoint = (start + end) / 2;
            if(input[midPoint] == value){
                return midPoint;
            }else if(input[midPoint] < value){
                start = midPoint + 1;
            }else{
                end = midPoint;
            }
        }

        return -1;
    }

    public static int binaryRecursive(int[] input, int value) {
        Arrays.sort(input);
        return binaryRecursive(input,0,input.length,value);
    }

    public static int binaryRecursive(int[] input, int start, int end, int value) {
        if(start >= end) {
            return - 1;
        }

        int midPoint = (start + end) / 2;
        if(input[midPoint] == value){
            return midPoint;
        }else if(input[midPoint] < value){
            return binaryRecursive(input,midPoint + 1, end, value);
        }else{
            return binaryRecursive(input,start, midPoint, value);
        }
    }
}
