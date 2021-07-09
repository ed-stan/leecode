package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        List<Character> list1=new ArrayList();
        List<Character> list2=new ArrayList();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                list1.add(s1.charAt(i));
                list2.add(s2.charAt(i));
            }
            if(list1.size()>2){
                return false;
            }
        }
        if (list1.size()==1){
            return false;
        }
        return list1.get(0) == list2.get(1) && list2.get(0) == list1.get(1);
    }

    public static void main(String[] args) {
        boolean b = areAlmostEqual("attack", "defend");
        System.out.println(b);
    }
}
