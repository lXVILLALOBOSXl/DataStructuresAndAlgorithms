package academy.learnprogramming.challenge3;

public class Main {

    public static void main(String[] args) {
        String[] stringsArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        // do radix sort
        radix(stringsArray, 23, stringsArray.length);

        for (int i = 0; i < stringsArray.length; i++) {
            System.out.println(stringsArray[i]);
        }
    }

    private static void radix(String[] array, int radix, int width){
        for (int i = width - 1; i > -1; i--) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(String[] array, int position, int radix){

        int numItems = array.length;

        int[] countArray = new int[radix];

        for (String word : array) {
            countAlphabetArray(countArray,word.charAt(position));
        }

        // Adjust the count array
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];

        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[ --countArray[ letterPosition( array[tempIndex].charAt(position)) ] ] = array[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            array[tempIndex] = temp[tempIndex];
        }
    }

    private static void countAlphabetArray(int[] countArray, char letter){

        switch (letter){
            case 'a':
                countArray[0]++;
                break;
            case 'b':
                countArray[1]++;
                break;
            case 'c':
                countArray[2]++;
                break;
            case 'd':
                countArray[3]++;
                break;
            case 'e':
                countArray[4]++;
                break;
            case 'f':
                countArray[5]++;
                break;
            case 'g':
                countArray[6]++;
                break;
            case 'h':
                countArray[7]++;
                break;
            case 'i':
                countArray[8]++;
                break;
            case 'j':
                countArray[9]++;
                break;
            case 'k':
                countArray[10]++;
                break;
            case 'l':
                countArray[11]++;
                break;
            case 'm':
                countArray[12]++;
                break;
            case 'n':
                countArray[13]++;
                break;
            case 'o':
                countArray[14]++;
                break;
            case 'p':
                countArray[15]++;
                break;
            case 'q':
                countArray[16]++;
                break;
            case 'r':
                countArray[17]++;
                break;
            case 's':
                countArray[18]++;
                break;
            case 't':
                countArray[19]++;
                break;
            case 'w':
                countArray[20]++;
                break;
            case 'x':
                countArray[21]++;
                break;
            case 'y':
                countArray[22]++;
                break;
            case 'z':
                countArray[23]++;
                break;
            default:
                break;
        }
    }

    private static int letterPosition(char letter){

        switch (letter){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'q':
                return 16;
            case 'r':
                return 17;
            case 's':
                return 18;
            case 't':
                return 19;
            case 'w':
                return 20;
            case 'x':
                return 21;
            case 'y':
                return 22;
            case 'z':
                return 23;
            default:
                return -1;
        }
    }

    //Teachers code
    public static void radixSort(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSortT(String[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (String value: input) {
            countArray[getIndex(position, value)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, input[tempIndex])]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    //Every char has an index by ASCII, if a is the first it only has to sub 'a' char
    public static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
    }

}
