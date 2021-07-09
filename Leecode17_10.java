package leecode;

import java.util.HashMap;
import java.util.Map;

public class Leecode17_10 {
    public static int majorityElement(int[] nums) {
        int max=nums[0];
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
            if(nums[i]!=max){
                if(map.get(nums[i])>map.get(max)){
                    max=nums[i];
                }
            }
        }
        if((float)map.get(max)/nums.length>0.5){
            return max;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr={2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
