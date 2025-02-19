package ru.dd;

/**Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place return the new length of the array.

 Example 1:

 Input: [2, 3, 3, 3, 6, 9, 9]
 Output: 4
 Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 Example 2:

 Input: [2, 2, 2, 11]
 Output: 2
 Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
//EASY
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int newLength = 0;

        if (nums.length == 0) {
            return newLength;
        }

        if (nums.length == 1) {
            return 1;
        }

        int left = 0;

        for (int i = 1; i < nums.length; i++) {
            var num = nums[i];

            if (num != nums[i-1]) {
                nums[left+1] = num;
                left++;
            }
        }

        return left+1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 3, 3, 6, 9, 9};
        int[] nums2 = {2, 2, 2, 11};

        int result1 = RemoveDuplicates.removeDuplicates(nums1);
        int result2 = RemoveDuplicates.removeDuplicates(nums2);

        System.out.println(result1);//4
        System.out.println(result2);//2
    }

}
