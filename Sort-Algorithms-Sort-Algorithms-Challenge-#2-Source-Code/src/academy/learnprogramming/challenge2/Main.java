package academy.learnprogramming.challenge2;

public class Main {


    /**
     * Make insertion sort with recursivity
     */

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        insertion(intArray, 1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void insertion(int[] array, int firstUnsortedIndex){

        // The first index (index 0) always will be on a correct position
        // it can't get out from the index size
        if(firstUnsortedIndex < 1 || firstUnsortedIndex >= array.length){
            return;
        }

        //Element to compare
        int newElement = array[firstUnsortedIndex];

        // If element to compare is lower than its before, they have to swap
        if ( array[firstUnsortedIndex] < array[firstUnsortedIndex - 1] ) {

            //swap
            array[firstUnsortedIndex] = array[firstUnsortedIndex - 1];
            array[firstUnsortedIndex - 1] = newElement;

            // it has to compare with its before postion again to find its correct place
            insertion(array, firstUnsortedIndex - 1);
        }

        //When its corre place was foun, it has to continue with the next number
        insertion(array, ++firstUnsortedIndex);

    }


    //Teacher's code
    public static void insertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("---------------------");


    }

}
