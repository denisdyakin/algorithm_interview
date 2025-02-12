package ru.dd;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
//EASY
public class AverageOfAllContiguousSubarraysKSizeTask {

    public static float[] findAverages(int[] nums, int k) {

        if (nums.length <= k) {
            throw new RuntimeException("array size is not valid");
        }

        int sum = 0;
        float[] result = new float[nums.length - k + 1];
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd<=nums.length-1; windowEnd++) {
                sum += nums[windowEnd];

                if (windowEnd >= k-1) {
                    result[windowStart] = (float) sum / k;
                    sum -= nums[windowStart];
                    windowStart++;
                }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        float[] averages = AverageOfAllContiguousSubarraysKSizeTask.findAverages(nums, 5);
        for (float average : averages) {
            System.out.println(average);
        }
    }

}
