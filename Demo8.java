package com;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
/*
罗马数字包含以下七种字符:I，V，X，L，C，D和M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，
所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 */
public class Demo8 {
    public static int romanToInt(String s) {
        Map<String ,Integer> map=new HashMap();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int res=0;

        for (int i = 0; i < s.length(); i++) {
            String  c = String.valueOf(s.charAt(i));
            if(i<s.length()-1){
                String  c1 = String.valueOf(s.charAt(i+1));
                if(map.get(c)<map.get(c1)){
                    res+=map.get(c1)-map.get(c);
                    i++;
                }else {
                    res+=map.get(c);
                }
            }else {
                res+=map.get(c);
            }
        }

//        for (int i = 0; i < s.length(); i++) {
//            String  c = String.valueOf(s.charAt(i));
//            if(c.equals("I")&&i<s.length()-1){
//                String  c1 = String.valueOf(s.charAt(i+1));
//                if(c1.equals("V") || c1.equals("X")){
//                    res+=map.get(c1)-map.get(c);
//                    i++;
//                }else {
//                    res+=map.get(c);
//                }
//            }else if(c.equals("X")&&i<s.length()-1){
//                String  c1 = String.valueOf(s.charAt(i+1));
//                if(c1.equals("L") || c1.equals("C")){
//                    res+=map.get(c1)-map.get(c);
//                    i++;
//                }else {
//                    res+=map.get(c);
//                }
//            }else if(c.equals("C")&&i<s.length()-1){
//                String  c1 = String.valueOf(s.charAt(i+1));
//                if(c1.equals("D") || c1.equals("M")){
//                    res+=map.get(c1)-map.get(c);
//                    i++;
//                }else {
//                    res+=map.get(c);
//                }
//            }else {
//                res+=map.get(c);
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        int num = romanToInt("III");
        System.out.println(num);
    }

}
