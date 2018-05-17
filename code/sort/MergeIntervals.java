package sort;


import java.util.*;

/**
 * @Author : wanghui
 * @Date : create on 2018/4/12
 * @Description:
 */
public class MergeIntervals {

    public static void main(String[] args) {

        Interval interval1 = new Interval(1,4);
        Interval interval2 = new Interval(5,6);
//        Interval interval3 = new Interval(8,10);
//        Interval interval4 = new Interval(15,18);

        List<Interval> list = new ArrayList<>(10);
        list.add(interval1);
//        list.add(interval4);
//        list.add(interval3);
        list.add(interval2);

        List<Interval> rst = merge(list);

    }

    public static List<Interval> merge(List<Interval> intervals) {

        if(intervals.isEmpty())
            return new ArrayList<>(0);

        //先对Interval按照start排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        //合并区间
        LinkedList<Interval> rst = new LinkedList<>();
        rst.add(intervals.get(0));

        for(Interval interval : intervals){

            Interval maxInterval = rst.getLast();

            if(interval.start <= maxInterval.end && interval.end > maxInterval.end){
                //合并之后更新
                rst.getLast().end = interval.end;
            }else if(interval.start > maxInterval.end){
                rst.add(interval);
            }
        }

        return rst;
    }

}

class Interval{

    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }

    Interval(int s, int e){
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
