package ru.dd;

/**
 * Given the head of a Singly LinkedList that contains a cycle,
 * write a function to find the starting node of the cycle.
 */
public class FastSlowStartOfLinkedListCycleTask {

    public static ListNode findStart(ListNode head) {

        ListNode slow = head, fast = head;

        //цикл - ищем зацикливание
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                //ищем длину зацикливания
                var cycleLength = findLength(slow);
                //ищем start point head, исходя из длины зацикливания (два указателя)
                return findStart(head, cycleLength);
            }

        }
        return slow;
    }

    public static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head;
        ListNode pointer2 = new ListNode(head.value);
        pointer2.next = head.next;

        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    public static int findLength(ListNode slow) {
        int length = 0;
        ListNode newSLow = new ListNode(slow.value);
        newSLow.next = slow.next;
        while (newSLow != slow) {
            newSLow = newSLow.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + findStart(head).value);
        //3
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + findStart(head).value);
        //4
        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList has cycle: " + findStart(head).value);
        //1
    }

}
