package leecode;

import java.util.Arrays;
import java.util.List;

public class Leecode539 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()>1440){
            return 0;
        }
        int[] arr=new int[timePoints.size()];
        int i=0;
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int m = Integer.parseInt(split[0]);
            int s = Integer.parseInt(split[1]);
            arr[i]=m*60+s;
            i++;
        }
        Arrays.sort(arr);
        int min=arr[1]-arr[0];
        for (i= 2; i<arr.length ; i++) {
            min=Math.min(min,arr[i]-arr[i-1]);
        }
        return Math.min(min,arr[0]-arr[arr.length-1]+1440);

    }

    public static void main(String[] args) {

        System.out.println(Integer.valueOf("1"));
    }
}
