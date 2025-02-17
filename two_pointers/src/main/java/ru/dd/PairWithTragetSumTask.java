package ru.dd;

import java.util.Arrays;

/**Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

 Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

 Example 1:

 Input: [1, 2, 3, 4, 6], target=6
 Output: [1, 3]
 Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 Example 2:

 Input: [2, 5, 9, 11], target=11
 Output: [0, 2]
 Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
//EASY
public class PairWithTragetSumTask {

    public static int[] search(int[] array, int targetSum) {

        int leftPoint = 0;
        int rightPoint = array.length - 1;
        int elementLeft = -1;
        int elementRight = -1;

        while (leftPoint < rightPoint) {
            elementLeft = array[leftPoint];
            elementRight = array[rightPoint];

            if (elementRight + elementLeft > targetSum) {
                rightPoint--;
                continue;
            }

            if (elementRight + elementLeft < targetSum) {
                leftPoint++;
                continue;
            }

            break;
        }

        return new int[] {leftPoint, rightPoint};
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 6};
        int targetSum = 6;
        System.out.println(Arrays.toString(PairWithTragetSumTask.search(array, targetSum)));//[1,3]

        array = new int[]{2, 5, 9, 11};
        targetSum = 11;
        System.out.println(Arrays.toString(PairWithTragetSumTask.search(array, targetSum)));//[0,2]
    }

}
