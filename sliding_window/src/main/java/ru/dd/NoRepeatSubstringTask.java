package ru.dd;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.

 * Example 1:

 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:

 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:

 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
//HARD
public class NoRepeatSubstringTask {

    public static int findLongestSub(String inString) {

        int maxLength = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < inString.length()) {
            var rightChar = inString.charAt(right);

            freqMap.merge(rightChar, 1, Integer::sum);

            int charFreq = freqMap.get(rightChar);
            while (charFreq > 1) {
                freqMap.put(inString.charAt(left), charFreq - 1);
                left++;
                charFreq = freqMap.get(rightChar);
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input1 = "aabccbb";
        String input2 = "abbbb";
        String input3 = "abccde";

        int result1 = NoRepeatSubstringTask.findLongestSub(input1);
        int result2 = NoRepeatSubstringTask.findLongestSub(input2);
        int result3 = NoRepeatSubstringTask.findLongestSub(input3);

        System.out.println(result1);//3
        System.out.println(result2);//2
        System.out.println(result3);//3
    }

}
