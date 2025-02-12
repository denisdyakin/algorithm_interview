package ru.dd;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 * Example 1:
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 * Example 2:
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * Example 3:
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
//EASY
public class SmallestSubarrayWithAGivenSumTask {

    public static void main(String[] args) {
        int[] array1 = {2, 1, 5, 2, 3, 2};
        int[] array2 = {2, 1, 5, 2, 8};
        int[] array3 = {3, 4, 1, 1, 6};

        int s1 = 7;
        int s2 = 7;
        int s3 = 8;

        int k1 = SmallestSubarrayWithAGivenSumTask.findSmallestSubarray(array1, s1);
        int k2 = SmallestSubarrayWithAGivenSumTask.findSmallestSubarray(array2, s2);
        int k3 = SmallestSubarrayWithAGivenSumTask.findSmallestSubarray(array3, s3);

        System.out.println(k1);//2
        System.out.println(k2);//1
        System.out.println(k3);//3
    }

    private static int findSmallestSubarray(int[] array, int s) {
        int smallestLength = array.length + 1;

        int windowStart = 0;
        int sum = 0;

        for(int windowEnd=0; windowEnd < array.length; windowEnd++) {
            sum += array[windowEnd];

            while (sum >= s) {
                smallestLength = Math.min(smallestLength, windowEnd - windowStart + 1);
                sum -= array[windowStart];
                windowStart++;
            }
        }

        return smallestLength == array.length + 1 ? 0 : smallestLength;
    }

}
