package com.fishercoder.solutions;

import com.fishercoder.common.classes.Interval;
import com.fishercoder.common.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class _56 {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);

        List<Interval> result = new ArrayList();
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while (i < intervals.size() && end >= intervals.get(i).start) {
                end = Math.max(end, intervals.get(i).end);
                i++;
            }
            result.add(new Interval(start, end));
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
//        //test case 1:
//    	list.add(new Interval(2,3));
//    	list.add(new Interval(5,5));
//    	list.add(new Interval(2,2));
//    	list.add(new Interval(3,4));
//    	list.add(new Interval(3,4));

        //test case 2:
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        CommonUtils.printList(merge(list));
    }

}
