package com.arrays;

public class Disadvantage {
    public static void main(String[] args) {
        //One disadvantage of arrays is if you don't know the index of the element that you will work it
        // the complex will be O of n in the worse case
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        //Example:
        //We have to find 7 into the array but we've not already know its index
        //In the worse case, supposing that it's in the last position. it will take n steps
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] == 7){
                System.out.printf("index = " + i);
                break;
            }
        }
    }
}
