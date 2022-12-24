package com.sortalgorithms;

public class Test {

    public static void main(String[] args) {

        //int[] arrayToTest = new int[]{ 20, 23, 24, 21};
        //int[] arrayToTest = new int[]{ 20, 35, -15, 7, 55, 1, -22 };
        //int[] arrayToTest = new int[]{ 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
        int[] arrayToTest = new int[]{ 4725, 4586, 1330, 8792, 1594, 5729 };
        System.out.println("Unsorted numbers: ");
        Test.printArray(arrayToTest);
        //System.out.println("BubbleSort: ");
        //Sort.bubble(arrayToTest);
        //System.out.println("SelectionSort: ");
        //Sort.selection(arrayToTest);
        //System.out.println("InsertionSort: ");
        //Sort.insertion(arrayToTest);
        //System.out.println("ShellSort: ");
        //Sort.shell(arrayToTest);
        //System.out.println("MergeSort: ");
        //Sort.merge(arrayToTest,0, arrayToTest.length);
        //System.out.println("QuickSort: ");
        //Sort.quick(arrayToTest, 0, arrayToTest.length);
        //System.out.println("CountingSort: ");
        //Sort.counting(arrayToTest, 1, 10);
        System.out.println("RadixSort: ");
        Sort.radix(arrayToTest, 10, 4);
        Test.printArray(arrayToTest);

    }

    private static void printArray(int[] array){
        System.out.print("{ ");
        for (int element : array) {
            System.out.print(element + ", ");
        }
        System.out.print(" }" + "\n");

    }
}
