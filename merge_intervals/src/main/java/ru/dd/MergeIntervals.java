package ru.dd;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

 * Example 1:
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].


 * Example 2:
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].

 * Example 3:
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 */
//MEDIUM
public class MergeIntervals {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<>();

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        var iterator = intervals.iterator();
        Interval currentInterval = iterator.next();

        Interval mergedInterval = new Interval(currentInterval.start, currentInterval.end);

        while (iterator.hasNext()) {
            currentInterval = iterator.next();

            if (mergedInterval.end >= currentInterval.start) {
                mergedInterval.end = Math.max(mergedInterval.end, currentInterval.end);
            } else {
                mergedIntervals.add(mergedInterval);
                mergedInterval = new Interval(currentInterval.start, currentInterval.end);
            }

        }

        mergedIntervals.add(mergedInterval);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }


}
