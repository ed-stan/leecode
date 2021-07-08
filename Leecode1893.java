package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leecode1893 {

    public static boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = 0; i < ranges.length; i++) {
            for (int j = 0; j < i; j++) {
                if(ranges[i][0]<ranges[j][0]){
                    int[] range = ranges[j];
                    ranges[j]=ranges[i];
                    ranges[i]=range;
                }
            }
        }
        int[] area={ranges[0][0],ranges[0][1]};
        if(area[0]<=left&&area[1]>=right){
            return true;
        }
        if (area[0]>left){
            return false;
        }
        for (int i = 1; i < ranges.length; i++) {
            if(ranges[i][0]>area[1]+1){
                area[0]=ranges[i][0];
            }
            if(ranges[i][1]>area[1]){
                area[1]=ranges[i][1];
            }

            if(area[0]<=left&&area[1]>=right){
                return true;
            }
            if (area[0]>left){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ranges={{36,50},{14,28},{4,31},{24,37},{13,36},{27,33},{23,32},{23,27},{1,35}};
        boolean covered = isCovered(ranges, 35, 40);
        System.out.println(covered);
    }
}
