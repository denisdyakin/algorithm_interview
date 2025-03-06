package ru.dd;


/**
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

 * Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished.
 * The algorithm should have
 * O(N)
 * O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

 * Example 1:

 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
 * Output: true
 * Example 2:

 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
 * Output: false
 */
public class PalindromeLinkedListTask {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var reversedHalf = revert(slow);

        while (reversedHalf != null) {
            if (reversedHalf.value != head.value) {
                return false;
            }
            reversedHalf = reversedHalf.next;
            head = head.next;
        }

        slow.next = revert(slow);

        return true;
    }

    private static ListNode revert(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head)); // true

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head2)); // false
    }

}
