package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Leecode560 {
    public static int subarraySum(int[] nums, int k) {
        int res=0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum==k){
                res++;
            }
            for (int j =i+1; j < nums.length; j++) {
                sum+=nums[j];
                if(sum==k){
                    res++;
                }
            }
            sum=0;
        }



//        Queue<Integer> queue= new LinkedList();
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]<k){
//                queue.add(nums[i]);
//                sum+=nums[i];
//            }else {
//                if(nums[i]==k){
//                    res++;
//                }
//                queue.clear();
//                sum=0;
//                continue;
//            }
//            if(sum==k){
//                res++;
//                sum=sum-queue.poll();
//
//            }
//            if(sum>k){
//                sum=sum-queue.poll();
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        int[]  arrays={-1,-1,1};
        int i = subarraySum(arrays, 0);
        System.out.println(i);

    }
}
