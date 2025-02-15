package ru.dd;

import java.util.*;

/**
 Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

 Example 1:

 Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 Output: [[1,3], [4,7], [8,12]]
 Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 Example 2:

 Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 Output: [[1,3], [4,12]]
 Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 Example 3:

 Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
 Output: [[1,4], [5,7]]
 Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].

 */
//MEDIUM
public class InsertIntervals {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new LinkedList<>();

        //Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
        int i;
        for (i = 0; i < intervals.size();) {
            var interval = intervals.get(i);
            if (interval.end <= newInterval.start) {
                mergedIntervals.add(interval);
                i++;
            }
            else break;
        }

        for (;i < intervals.size();) {
            var interval = intervals.get(i);

            if (interval.start > newInterval.end) {
                break;
            }

            newInterval.start = Math.min(interval.start, newInterval.start);
            newInterval.end = Math.max(interval.end, newInterval.end);

            i++;
        }

        mergedIntervals.add(newInterval);

        for (;i< intervals.size();i++) {
            mergedIntervals.add(intervals.get(i));
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        var newInterval = new Interval(4, 6);
        System.out.print("Intervals: ");
        for (Interval interval : InsertIntervals.insert(input, newInterval))
            System.out.print("[" + interval.start + "," + interval.end + "] "); //[[1,3], [4,7], [8,12]]
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        var newInterval2 = new Interval(4, 10);
        System.out.print("Intervals: ");
        for (Interval interval : InsertIntervals.insert(input, newInterval2))
            System.out.print("[" + interval.start + "," + interval.end + "] "); //[[1,3], [4,12]]
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        var newInterval3 = new Interval(1, 4);
        System.out.print("Intervals: ");
        for (Interval interval : InsertIntervals.insert(input, newInterval3))
            System.out.print("[" + interval.start + "," + interval.end + "] "); //[[1,4], [5,7]]
        System.out.println();
    }


}
