package ru.dd;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

 * Example 1:

 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:

 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:

 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
//HARD
public class LongestSubstringWithSameLettersAfterReplacement {

    public static int findLength(String string, int k) {
        int length = 0;

        int left = 0, right = 0, maxRepeatCount = 0;

        //[aabc]cbb

        Map<Character, Integer> freqMap = new HashMap<>();

        while (right < string.length()) {

            var character = string.charAt(right);

            freqMap.merge(character, 1, Integer::sum);

            maxRepeatCount = Math.max(maxRepeatCount, freqMap.get(character));

            if (right - left + 1 - maxRepeatCount > k) {
                var leftCharacter = string.charAt(left);

                if (freqMap.get(leftCharacter) == 0) {
                    freqMap.remove(leftCharacter);
                } else {
                    freqMap.put(leftCharacter, freqMap.get(leftCharacter) - 1);
                }

                left++;
            }

            length = Math.max(length, right - left + 1);

            right++;
        }


        return length;
    }

    public static void main(String[] args) {
        var string1 = "aabccbb";
        var string2 = "abbcb";
        var string3 = "abccde";

        int result1 = LongestSubstringWithSameLettersAfterReplacement.findLength(string1, 2);
        int result2 = LongestSubstringWithSameLettersAfterReplacement.findLength(string2, 1);
        int result3 = LongestSubstringWithSameLettersAfterReplacement.findLength(string3, 1);

        System.out.println(result1);//5
        System.out.println(result2);//4
        System.out.println(result3);//3
    }

}
