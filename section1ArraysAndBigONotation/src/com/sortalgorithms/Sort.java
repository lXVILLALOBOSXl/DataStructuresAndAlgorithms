package com.sortalgorithms;

public class Sort {

    /**
     * From left to right
     * Compares and swap to the right if its greater
     * in place algorithm
     * O (n2)
     * stable algortihm
     * @param array
     */
    public static void bubble(int[] array){

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(array[i] > array[i+1]){
                    Sort.swap(array, i, i+1);
                }
            }
        }

    }

    /**
     * From left to right
     * Compares who is the greatest to select its index to put to the right
     * in place algorithm
     * O (n2)
     * Unstable algorithm
     * @param array
     */
    public static void selection(int[] array){

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {

                if(array[i] > array[largest]){
                    largest = i;
                }
            }

            Sort.swap(array, largest, lastUnsortedIndex);
        }

    }


    /**
     * From right to left
     * compares who is minus to open a space in its correct position
     * in place algorithm
     * O (n2)
     * Stable algorithm
     * @param array
     */
    public static void insertion(int[] array) {

        for(int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++){

            int newElement = array[firstUnsortedIndex];

            int i;

            for(i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--){

                array[i] = array[i - 1];

            }

            array[i] = newElement;
        }


    }

    /**
     * From right to Left
     * is a variation of insertionSort with the difference that it first sort by halfs
     * what are lower or higher
     * In place algorithm
     * O (n2) - In worst case but performs better than insertion sort in majority cases
     * Unstable algorithm
     * @param array
     */
    public static void shell(int[] array){

        for(int gap = array.length / 2; gap > 0; gap /= 2){

            for (int i = gap; i < array.length; i++) {

                int newElement = array[i];

                int j = i;

                while(j >= gap && array[j - gap] >  newElement){

                    array[j] = array[j - gap];
                    j -= gap;

                }

                array[j] = newElement;

            }

        }

    }

    /**
     * Divide and conquer algortihm, it divides all the array in halfs recursively to get only an array
     * from only one position, and when it happens returns sorting by halfs and saving in auxiliar arraya
     * Not in place algorthm
     * O (nlogn) base 2
     * Stable algortihm
     * @param array
     * @param start
     * @param end
     */
    public static void merge(int[] array, int start, int end){

        if(end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        merge(array, start, mid);
        merge(array, mid, end);
        mergeSort(array, start, mid, end);
    }

    private static void mergeSort(int[] array, int start, int mid, int end) {

        if(array[mid - 1] <= array[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while(i < mid && j < end){
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);

    }


    /**
     * It selects a pivot and compares from left to right and right to left, positioning to left
     * pivot elements that are less than pivot and right pivot elements that are greater than pivot
     * In-place algorithm
     * O(nlogn) base 2, in the worst cacse its complexity will be O(n2)
     * Unstable algorithm
     * @param array
     */
    public static void quick(int[] array, int start, int end){

        if(end - start < 2){
            return;
        }

        int pivotIndex = partition(array, start, end);
        quick(array, start, pivotIndex);
        quick(array, pivotIndex + 1, end);

    }

    private static int partition(int[] array, int start, int end){

        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j){

            while (i < j && array[--j] >= pivot);
            if(i < j){
                array[i] = array[j];
            }

            while (i < j && array[++i] <= pivot);
            if(i < j){
                array[j] = array[i];
            }

        }

        array[j] = pivot;
        return j;

    }

    /**
     * It doesn't need comparisioons, assumes that values into array are minus or equal to
     * the size of the array, for example: if ypu have an array of lenght ten, the array content
     * should have ints form 0 to ten.
     * It counts how manny numbers are in the array and put it count in its position
     * then sort by the count
     * Not in-place algotithm
     * O (n)
     * stable algorithm with extra steps
     * @param array
     */
    public static void counting(int[] array, int min, int max){

        int[] countingArray = new int[(max - min) + 1];

        for (int i = 0; i < array.length; i++){

            countingArray[array[i] - min]++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {

            while (countingArray[i - min] > 0){
                array[j++] = i;
                countingArray[i - min]--;
            }
        }
    }


    /**
     * conditions to use: All the elements should have the same width and they have to be based on the combination for each postion (radix)
     * Radix is the number of variants that an element of array can have for example: for every number in position you have a radix of 10
     * because you only have (0-9) for each position
     *
     * Radix sort starts comparing every position in the content of every position in the array and compares
     * with the same position to other position in the array, for example imagine that ypu have 1234 and 5678, radix sdtarts comparin unitys, and then
     * tens, cents, etc. but you have to make it stable, you have tou use counting sort to take an order, for example if you have
     * the same number position in 2 different contents (1234 5674 - 4 repeats) you have to count how many numers follow it and then return int by its count
     * @param array
     * @param radix
     * @param width
     */
    public static void radix(int[] array, int radix, int width){
        for (int i = 0; i < width; i++) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(int[] array, int position, int radix) {

        int numItems = array.length;

        int[] countArray = new int[radix];

        for (int value: array){
            countArray[getDigit(position, value, radix)]++;
        }

        // Adjust the count array
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];

        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            //it first search where (in what position) in the count array is every digit of the every position in the array
            //and when the number is found, that index will be the correct position in the new array order and we reduce one because we've already found it
            temp[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            array[tempIndex] = temp[tempIndex];
        }

    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    private static void swap(int[] array, int i, int j){

        if(i == j){
            return;
        }

        int auxiliar = array[i];
        array[i] = array[j];
        array[j] = auxiliar;
    }

}
