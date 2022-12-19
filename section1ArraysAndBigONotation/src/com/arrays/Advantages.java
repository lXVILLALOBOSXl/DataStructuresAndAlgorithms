package com.arrays;

public class Advantages {
    public static void main(String[] args) {
        //One advantage of iarrays is if you know the index of the element that you will worki it
        // the complex will be O of 1 (linear)
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        //Example:
        //We have to find 7 into the array but we've already know its index
        //In one step we can solve it
        System.out.println(intArray[3]);

    }
}
