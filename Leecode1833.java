package leecode;

import java.util.Arrays;

public class Leecode1833 {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res=0;
        for (int i = 0; i < costs.length; i++) {
            if(coins>=costs[i]){
                coins=coins-costs[i];
                res++;
            }
            if(coins<=0){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,1};
        int i = maxIceCream(arr, 7);
        System.out.println(i);

    }


}

