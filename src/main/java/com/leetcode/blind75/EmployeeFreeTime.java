package com.leetcode.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public static void main(String[] args) {
        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
        List<List<Interval>> avails = employeeFreeTime.buildInput();
        List<Interval> intervals = employeeFreeTime.employeeFreeTime(avails);
        System.out.println(intervals);
    }

    private List<List<Interval>> buildInput() {
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 2));
        intervals1.add(new Interval(5, 6));

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 3));

        List<Interval> intervals3 = new ArrayList<>();
        intervals3.add(new Interval(4, 10));
//        intervals3.add(new Interval(9, 12));

        List<List<Interval>> lists = new ArrayList<>();
        lists.add(intervals1);
        lists.add(intervals2);
        lists.add(intervals3);
        return lists;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> result = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();
        List<Integer> lower = new ArrayList<>();
        int employeeCount = avails.size();
        for (int i = 0; i < employeeCount; i++) {
            List<Interval> employeeIntervals = avails.get(i);
            for (int j = 0; j < employeeIntervals.size(); j++) {
                Interval interval = employeeIntervals.get(j);
                lower.add(interval.start);
                upper.add(interval.end);
            }
        }
        Collections.sort(upper);
        Collections.sort(lower);

        for (int i = 0; i < upper.size() - 1; i++) {
            if (upper.get(i) < lower.get(i + 1)) {
                Interval interval = new Interval(upper.get(i), lower.get(i + 1));
                result.add(interval);
            }
        }

        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}