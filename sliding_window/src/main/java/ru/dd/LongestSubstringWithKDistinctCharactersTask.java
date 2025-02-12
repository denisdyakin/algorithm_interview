package ru.dd;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

 * Example 1:

 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:

 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:

 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
//MEDIUM
public class LongestSubstringWithKDistinctCharactersTask {

    public static void main(String[] args) {

        String inString1 = "araaci";
        int k1 = 2;
        String inString2 = "araaci";
        int k2 = 1;
        String inString3 = "cbbebi";
        int k3 = 3;

        int result1 = LongestSubstringWithKDistinctCharactersTask.findLongestSub(inString1, k1);
        int result2 = LongestSubstringWithKDistinctCharactersTask.findLongestSub(inString2, k2);
        int result3 = LongestSubstringWithKDistinctCharactersTask.findLongestSub(inString3, k3);

        System.out.println(result1);//4
        System.out.println(result2);//2
        System.out.println(result3);//5


    }

    private static int findLongestSub(String inString, int k) {
        int maxLength = 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < inString.length(); windowEnd++) {
            var rightChar = inString.charAt(windowEnd);

            freqMap.merge(rightChar, 1, Integer::sum);

            while (freqMap.size() > k) {
                var leftChar = inString.charAt(windowStart);
                Integer count = freqMap.get(leftChar);
                if (count - 1 == 0) {
                    freqMap.remove(leftChar);
                } else {
                    freqMap.put(inString.charAt(windowStart), count - 1);
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

}
