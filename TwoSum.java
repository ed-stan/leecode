package leecode;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        quitsort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            if(i>target){
                break;
            }else{
                for(int j=0;j<i;j++){
                    if(nums[i]+nums[j]==target){
                        result[0]=i;
                        result[1]=j;
                    }
                }
            }
        }
        return result;
    }
    public static int getIndex(int[] arr,int low,int high){
        int num = arr[low];
        while (high>low){
            while (high>low&&arr[high]>=num){
                high--;
            }
            arr[low]=arr[high];

            while (high>low&&arr[low]<=num){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=num;
        return low;
    }
    public static void quitsort(int[] arr,int low,int high ){
        if (low<high){
            int index = getIndex(arr,low,high);
            quitsort(arr,low,index-1);
            quitsort(arr,index+1,high);
        }
    }

    public static void main(String[] args) {

    }
}
