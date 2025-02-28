package ru.dd;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.

 * Example 1:

 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * Example 2:

 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
//HARD
public class LongestSubarrayWithOnesAfterReplacementTask {

    public static int findLength(int[] array, int k) {

        int maxLength = 0;
        int leftAnchor = 0, rightAnchor = 0;
        int onesCount = 0;

        while (rightAnchor < array.length) {
            var rightNum = array[rightAnchor];

            if (rightNum == 1) {
                onesCount++;
            }

            if ((rightAnchor - leftAnchor + 1 - onesCount) > k) {
                int leftNum = array[leftAnchor];
                if (leftNum == 1) {
                    onesCount--;
                }
                leftAnchor++;
            }

            var nextLength = rightAnchor - leftAnchor + 1;
            maxLength = Math.max(nextLength, maxLength);
            rightAnchor++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int[] array2 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};

        int k1 = 2;
        int k2 = 3;

        int result1 = LongestSubarrayWithOnesAfterReplacementTask.findLength(array1, k1);
        int result2 = LongestSubarrayWithOnesAfterReplacementTask.findLength(array2, k2);

        System.out.println(result1);//6
        System.out.println(result2);//9
    }
}
