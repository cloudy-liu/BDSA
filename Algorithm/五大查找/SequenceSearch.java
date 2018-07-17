/**
 * Author: cloudy Date: 2018-7-15
 */

public class SequenceSearch {
    /**
     * @return -1 not found else return index
     */
    public static int sequenceSearch(int[] data, int len, int key) {
        /* 
        for (int i = 0; i < len; i++) {
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
         */
        int i = len - 1;
        data[0] = key;
        while (data[i] != key) {
            i--;
        }
        return i; // if not found i=0
    }

    public static void main(String[] args) {
        int[] data = new int[] { 1, 27, 8, 10, 34, 56, 11 };
        System.out.println(sequenceSearch(data, data.length, 11));
    }
}