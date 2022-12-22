package com.sortalgorithms;

public class Test {

    public static void main(String[] args) {

        int[] arrayToTest = new int[]{ 20, 23, 24, 21};
        //int[] arrayToTest = new int[]{ 20, 35, -15, 7, 55, 1, -22 };
        System.out.println("Unsorted numbers: ");
        Test.printArray(arrayToTest);
        //System.out.println("BubbleSort: ");
        //Test.printArray(Sort.bubble(arrayToTest));
        //System.out.println("SelectionSort: ");
        //Test.printArray(Sort.selection(arrayToTest));
        //System.out.println("InsertionSort: ");
        //Test.printArray(Sort.insertion(arrayToTest));
        //System.out.println("ShellSort: ");
        //Test.printArray(Sort.shell(arrayToTest));
        System.out.println("MergeSort: ");
        Sort.merge(arrayToTest,0, arrayToTest.length);
        Test.printArray(arrayToTest);
        //Test.printArray();

    }

    private static void printArray(int[] array){
        System.out.print("{ ");
        for (int element : array) {
            System.out.print(element + ", ");
        }
        System.out.print(" }" + "\n");

    }
}
