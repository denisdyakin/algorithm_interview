package ru.dd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

 * Example 1:

 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 * Example 2:

 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 * Example 3:

 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 *
 */
//MEDIUM
public class ConflictingAppointmentsTask {

    public static boolean canAttendAllAppointments(Interval[] intervals) {

        //sort intervals
        Arrays.sort(intervals, Comparator.comparing(o -> o.start));

        boolean flag = true;

        int i = 0;
        while (flag && ((i+1) < intervals.length)) {

            var intervalLeft = intervals[i];
            var intervalRight = intervals[i+1];

            flag = intervalLeft.end < intervalRight.start;

            i++;
        }


        return flag;
    }

    public static void main(String[] args) {
        Interval[] input = new Interval[] { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        System.out.println("Can attend all appointments: " + ConflictingAppointmentsTask.canAttendAllAppointments(input));
        // Output: false

        input = new Interval[] { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        System.out.println("Can attend all appointments: " + ConflictingAppointmentsTask.canAttendAllAppointments(input));
        // Output: true

        input = new Interval[] { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        System.out.println("Can attend all appointments: " + ConflictingAppointmentsTask.canAttendAllAppointments(input));
        // Output: false
    }


}
