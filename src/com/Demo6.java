package com;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个非递减的有序整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 * 示例：
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 */
public class Demo6 {

    public static int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                int x= map.get(arr[i]);
                map.put(arr[i], x + 1);
            }
        }
        int res=0;
        for (int i : arr) {
            if ((float)map.get(i)/ arr.length>= 0.25) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,6,6,6,6,7,10};
        int specialInteger = findSpecialInteger(arr);
        System.out.println(specialInteger);
    }
}
