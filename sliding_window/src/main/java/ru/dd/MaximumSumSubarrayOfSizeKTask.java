package ru.dd;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 * Example 1
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumSubarrayOfSizeKTask {

    public static void main(String[] args) {
        int[] input = {2, 1, 5, 1, 3, 2};
        int k =3;
        int maxSum = MaximumSumSubarrayOfSizeKTask.findMxSum(input, k);
        System.out.println(maxSum); //9

        int [] input2 = {2, 3, 4, 1, 5};
        int k2 = 2;
        maxSum = MaximumSumSubarrayOfSizeKTask.findMxSum(input2, k2);
        System.out.println(maxSum); //7
    }

    private static int findMxSum(int[] input, int k) {
        int maxSum = 0;

        int windowStart = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            sum += input[windowEnd];

            if (windowEnd >= k - 1) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum -= input[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

}
