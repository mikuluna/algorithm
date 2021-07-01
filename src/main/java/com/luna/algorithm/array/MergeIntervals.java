package com.luna.algorithm.array;
//56. 合并区间
//        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//         
//
//        示例 1：
//
//        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出：[[1,6],[8,10],[15,18]]
//        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2：
//
//        输入：intervals = [[1,4],[4,5]]
//        输出：[[1,5]]
//        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//         
//
//        提示：
//
//        1 <= intervals.length <= 10^4
//        intervals[i].length == 2
//        0 <= starti <= endi <= 10^4


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MergeIntervals {


    public int[][] mergeTest(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        List<int[]> result = new ArrayList<>();
        for(int i = 0;i < intervals.length ; i ++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(result.size() == 0 || result.get(result.size()-1)[1] < left){
                result.add(new int[]{left,right});
            }else{
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],right);
            }
        }
        return result.toArray(new int[result.size()][]);
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}