package leecode;

import java.util.Arrays;

public class Leecode1608 {
    public static int specialArray(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        if (max == 0) {
            return -1;
        }
        int res;
        for (int i = 0; i <= max; i++) {
            res = 0;
            for (int num : nums) {
                if (num >= i) {
                    res++;
                }
                if (res > i) {
                    break;
                }
            }
            if(res==i){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(arr.length);
        int i = specialArray(arr);
        System.out.println(i);
    }
}
