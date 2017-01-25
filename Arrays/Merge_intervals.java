//https://www.interviewbit.com/problems/merge-intervals/

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> returnValue = new ArrayList<Interval>();
        
        Interval intervalToInsert = newInterval;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            //System.out.println("Checking, insert=(" + intervalToInsert + "), current=(" + interval + ")");
            if (intervalToInsert == null || interval.end < intervalToInsert.start) {
                returnValue.add(interval);
            } else if (intervalToInsert.end < interval.start) {
                returnValue.add(intervalToInsert);
                returnValue.add(interval);
                intervalToInsert = null;
            } else {
                intervalToInsert = new Interval(Math.min(interval.start, intervalToInsert.start),
                                                Math.max(interval.end, intervalToInsert.end));
            }
        }
        if (intervalToInsert != null) {
            returnValue.add(intervalToInsert);    
        }
        
        return returnValue;
    }
}


/**
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

**/
