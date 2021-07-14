package one;

public class Leecode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result=0;

        int arrLength1=nums1.length;
        int arrLength2=nums2.length;
        int[] myArr=new int[arrLength1+arrLength2];

        if (arrLength1==0){
            myArr=nums2;
        }else if (arrLength2==0){
            myArr=nums1;
        }else {
            for (int i = 0; i <arrLength1 ; i++) {
                myArr[i]=nums1[i];
            }
            for (int i = 0; i < arrLength2; i++) {
                myArr[i+arrLength1]=nums2[i];
            }
            int a=0;
            for (int i = 0; i <myArr.length ; i++) {
                for (int j = 0; j <i ; j++) {
                    if (myArr[i]<myArr[j]){
                        a=myArr[i];
                        myArr[i]=myArr[j];
                        myArr[j]=a;
                    }

                }
            }
        }

        if (myArr.length % 2 == 0) {
            int num1=myArr[myArr.length / 2];
            int num2=myArr[(myArr.length / 2) - 1];

            result = (num1+num2) / 2.0;

        } else {
            result = myArr[myArr.length / 2];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
