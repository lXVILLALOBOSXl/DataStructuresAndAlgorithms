package com.sortalgorithms;

public class Sort {

    /**
     * From left to right
     * Compares and swap to the right if its greater
     * @param array
     * @return
     */
    public static int[] bubble(int[] array){

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(array[i] > array[i+1]){
                    Sort.swap(array, i, i+1);
                }
            }
        }

        return array;

    }

    /**
     * From left to right
     * Compares who is the greatest to select its index to put to the right
     * @param array
     * @return
     */
    public static int[] selection(int[] array){

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {

                if(array[i] > array[largest]){
                    largest = i;
                }

            }

            Sort.swap(array, largest, lastUnsortedIndex);

        }

        return array;

    }


    /**
     * From right to left
     * compares who is minus to open a space in its correct position
     * @param array
     * @return
     */
    public static int[] insertion(int[] array) {

        for(int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++){

            int newElement = array[firstUnsortedIndex];

            int i;

            for(i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--){

                array[i] = array[i - 1];

            }

            array[i] = newElement;
        }

        return array;

    }

    /**
     * From right to Left
     * is a variation of insertionSort with the difference that it first sort by halfs
     * what are lower or higher
     * @param array
     * @return
     */
    public static int[] shell(int[] array){

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

        return array;
    }

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

    private static void swap(int[] array, int i, int j){

        if(i == j){
            return;
        }

        int auxiliar = array[i];
        array[i] = array[j];
        array[j] = auxiliar;
    }

}
