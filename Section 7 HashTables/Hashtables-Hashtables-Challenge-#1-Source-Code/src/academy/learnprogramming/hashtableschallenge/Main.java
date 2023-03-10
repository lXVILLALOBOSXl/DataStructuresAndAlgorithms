package academy.learnprogramming.hashtableschallenge;

public class Main {

    public static void main(String[] args) {

        int[] nums = new int[10];
        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
        for (int i = 0; i < numsToAdd.length; i++) {
            nums[hash(numsToAdd[i])] = numsToAdd[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //My solution
    public static int hash(int value) {
        return Math.abs(value / (int)Math.pow(10, Integer.toString(Math.abs(value)).length() - 1));
    }

    //Teacher's solution
    /*public static int hash(int value) {
        return Math.abs(value % 10);
    }*/
}
