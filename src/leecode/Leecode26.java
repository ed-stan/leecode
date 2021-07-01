package leecode;

import java.util.Arrays;

/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 */
public class Leecode26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1, j = 1, res = 1;
        while (k < nums.length) {
            if (nums[k] != nums[k - 1]) {
                nums[j] = nums[k];
                res++;
                j++;
            }
            k++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2};
        int i = removeDuplicates(arr);
    }

}
