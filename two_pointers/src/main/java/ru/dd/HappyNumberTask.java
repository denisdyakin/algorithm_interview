package ru.dd;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum
 * of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’.
 * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

 * Example 1:

 * Input: 23
 * Output: true (23 is a happy number)
 * Explanations: Here are the steps to find out that 23 is a happy number:
 */
public class HappyNumberTask {

    public static boolean isHappy(int number) {

        var slowPointer = number;
        var fastPointer = number;

        do {
            slowPointer = calcSqrt(slowPointer);
            fastPointer = calcSqrt(calcSqrt(fastPointer));
        } while (slowPointer != fastPointer);

        return slowPointer == 1;
    }

    private static int calcSqrt(int num) {
        int sum = 0;
        while(num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit * lastDigit;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(23));//true
        System.out.println(isHappy(12));//false
    }

}
