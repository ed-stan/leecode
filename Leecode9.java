package one;

import java.util.ArrayList;
import java.util.List;

public class Leecode9 {
//    public static boolean isPalindrome(int x) {
//        StringBuffer s = new StringBuffer(String.valueOf(x));
//        StringBuffer reverse = s.reverse();
//        return String.valueOf(x).equals(reverse.toString());
//    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if (x<10)
            return true;
        List<Integer> list = new ArrayList<>();
        while (x>0){
            list.add(x%10);
            x=x/10;
        }
        int high=list.size()-1;
        int low=0;
        while (true){
            if(!list.get(high).equals(list.get(low))){
                return false;
            }
            if(high==low||high-low==1){
                return true;
            }
            high--;
            low++;
        }

    }

    public static void main(String[] args) {
        boolean flag = isPalindrome(0);
        System.out.println(flag);
    }
}
