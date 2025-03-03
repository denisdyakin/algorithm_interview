package ru.dd;

import java.util.*;

import static ru.dd.Interval.of;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.

 * Example 1:

 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:

 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * Example 3:

 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.

 * Example 4:
 [[2,3], [2,4], [3,5], [4,5]]
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 */
//HARD
public class MinimumMeetingRoomsTask {

    public static int findMinCountRooms(List<Interval> meetings) {

        int minRoomsCount = 0;
        int i = 0;

        meetings.sort(Comparator.comparingInt(o -> o.start));

        final PriorityQueue<Integer> activeMeets = new PriorityQueue<>();

        while (i < meetings.size()) {
            var meeting = meetings.get(i);

            var prevMeeting = activeMeets.peek();
            while (prevMeeting != null && prevMeeting <= meeting.start) {
                activeMeets.poll();
                prevMeeting = activeMeets.peek();
            }

            activeMeets.add(meeting.end);

            minRoomsCount = Math.max(minRoomsCount, activeMeets.size());

            i++;
        }

        return minRoomsCount;
    }

    public static void main(String[] args) {
        List<Interval> input = Arrays.asList(of(1, 4), of(2, 5), of(7, 9));
        System.out.println("Minimum number of rooms required: " + findMinCountRooms(input));
        // output: 2

        input = Arrays.asList(of(6, 7), of(2, 4), of(8, 12));
        System.out.println("Minimum number of rooms required: " + findMinCountRooms(input));
        // output: 1

        input = Arrays.asList(of(1, 4), of(2, 3), of(3, 6));
        System.out.println("Minimum number of rooms required: " + findMinCountRooms(input));
        // output: 2

        input = Arrays.asList(of(4, 5), of(2, 3), of(2, 4), of(3, 5));
        System.out.println("Minimum number of rooms required: " + findMinCountRooms(input));
        // output: 2
    }

}
