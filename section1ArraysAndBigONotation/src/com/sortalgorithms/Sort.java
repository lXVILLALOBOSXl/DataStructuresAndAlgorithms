package com.sortalgorithms;

import java.util.*;

public class Sort {

    /**
     * From left to right
     * Compares and swap to the right if its greater
     * in place algorithm
     * O (n2)
     * stable algortihm
     * @param input
     */
    public static void bubble(int[] input){

        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(input[i] > input[i+1]){
                    Sort.swap(input, i, i+1);
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
     * @param input
     */
    public static void selection(int[] input){

        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {

                if(input[i] > input[largest]){
                    largest = i;
                }
            }

            Sort.swap(input, largest, lastUnsortedIndex);
        }

    }


    /**
     * From right to left
     * compares who is minus to open a space in its correct position
     * in place algorithm
     * O (n2)
     * Stable algorithm
     * @param input
     */
    public static void insertion(int[] input) {

        for(int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++){

            int newElement = input[firstUnsortedIndex];

            int i;

            for(i = firstUnsortedIndex; i > 0 && input[i - 1] > newElement; i--){

                input[i] = input[i - 1];

            }

            input[i] = newElement;
        }


    }

    /**
     * From right to Left
     * is a variation of insertionSort with the difference that it first sort by halfs
     * what are lower or higher
     * In place algorithm
     * O (n2) - In worst case but performs better than insertion sort in majority cases
     * Unstable algorithm
     * @param input
     */
    public static void shell(int[] input){

        for(int gap = input.length / 2; gap > 0; gap /= 2){

            for (int i = gap; i < input.length; i++) {

                int newElement = input[i];

                int j = i;

                while(j >= gap && input[j - gap] >  newElement){

                    input[j] = input[j - gap];
                    j -= gap;

                }

                input[j] = newElement;

            }

        }

    }

    /**
     * Divide and conquer algortihm, it divides all the array in halfs recursively to get only an array
     * from only one position, and when it happens returns sorting by halfs and saving in auxiliar arraya
     * Not in place algorthm
     * O (nlogn) base 2
     * Stable algortihm
     * @param input
     * @param start
     * @param end
     */
    public static void merge(int[] input, int start, int end){

        if(end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        merge(input, start, mid);
        merge(input, mid, end);
        mergeSort(input, start, mid, end);
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
     * @param input
     */
    public static void quick(int[] input, int start, int end){

        if(end - start < 2){
            return;
        }

        int pivotIndex = partition(input, start, end);
        quick(input, start, pivotIndex);
        quick(input, pivotIndex + 1, end);

    }

    private static int partition(int[] input, int start, int end){

        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j){

            while (i < j && input[--j] >= pivot);
            if(i < j){
                input[i] = input[j];
            }

            while (i < j && input[++i] <= pivot);
            if(i < j){
                input[j] = input[i];
            }

        }

        input[j] = pivot;
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
     * @param input
     */
    public static void counting(int[] input, int min, int max){

        int[] countingArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++){

            countingArray[input[i] - min]++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {

            while (countingArray[i - min] > 0){
                input[j++] = i;
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
     * @param input
     * @param radix
     * @param width
     */
    public static void radix(int[] input, int radix, int width){
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;

        int[] countArray = new int[radix];

        for (int value: input){
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
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            input[tempIndex] = temp[tempIndex];
        }

    }

    public static void bucket(int[] input) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                input[j++] = value;
            }
        }

    }

    private static int hash(int value) {
        return value / (int) 10;
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    private static void swap(int[] input, int i, int j){

        if(i == j){
            return;
        }

        int auxiliar = input[i];
        input[i] = input[j];
        input[j] = auxiliar;
    }

}
