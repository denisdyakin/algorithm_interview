package ru.dd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
 *
 * Example 1:
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 *
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */
//MEDIUM
public class IntervalsIntersectionTask {

    public static Interval[] merge(Interval[] intervals1, Interval[] intervals2) {
        List<Interval> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        for(; i < intervals1.length && j < intervals2.length;) {
            var intervalLeft = intervals1[i];
            var intervalRight = intervals2[j];

            if ((intervalRight.start >= intervalLeft.start && intervalRight.start <= intervalLeft.end)
                    ||  ( intervalLeft.start >= intervalRight.start && intervalLeft.start <= intervalRight.end)) {
                result.add(new Interval(Math.max(intervalLeft.start, intervalRight.start), Math.min(intervalLeft.end, intervalRight.end)));
            }

            if (intervalLeft.end < intervalRight.end) {
                i++;
            } else {
                j++;
            }

        }

        return result.toArray(new Interval[result.size()]);
    }


    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersectionTask.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] "); //[2,3], [5,6], [7,7]
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersectionTask.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] "); //[5,7], [9,10]
    }

}
