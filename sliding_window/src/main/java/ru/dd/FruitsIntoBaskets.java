package ru.dd;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is
 * to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.

 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

 * Write a function to return the maximum number of fruits in both the baskets.

 * Example 1:

 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

 * Example 2:

 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
//MEDIUM
public class FruitsIntoBaskets {

    public static int findLength(char[] fruits) {
        int maxLenght = 0;

        //сформировали окно
        int left = 0;
        int right = 0;

        //счетчик деревьев
        int basketsNumber = 2;

        Map<Character, Integer> charCounter = new HashMap<>();

        for (; right < fruits.length; right++) {
            var leftChar = fruits[left];
            var rightChar = fruits[right];

            charCounter.merge(rightChar, 1, Integer::sum);

            //shrink
            while (charCounter.size() > basketsNumber) {
                var leftCharCount = charCounter.get(leftChar);
                if (leftCharCount - 1 == 0) {
                    charCounter.remove(leftChar);
                } else {
                    charCounter.put(leftChar, leftCharCount - 1);
                }
                left++;
            }

            maxLenght = Math.max(maxLenght, right - left + 1);
        }

        return maxLenght;
    }

    public static void main(String[] args) {
        //['A', 'B', 'C', 'A', 'C']
        char[] fruits1 = {'A', 'B', 'C', 'A', 'C'};
        int result1 = FruitsIntoBaskets.findLength(fruits1);
        System.out.println(result1); //3

        //['A', 'B', 'C', 'B', 'B', 'C']
        char[] fruits2 = {'A', 'B', 'C', 'B', 'B', 'C'};
        int result2 = FruitsIntoBaskets.findLength(fruits2);
        System.out.println(result2); //5
    }

}
