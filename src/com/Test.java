package com;

import java.util.*;


public class Test {
    public static int longestBeautifulSubstring(String word) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map=new HashMap();

        sb.append(word.charAt(0));
        map.put(word.charAt(0),1);
        int max = 0;

        for (int i = 1; i < word.length(); i++) {
            if ((word.charAt(i) - sb.charAt(sb.length() - 1)) >= 0) {
                sb.append(word.charAt(i));
                map.put(word.charAt(i),1);
                if (map.size()==5) {
                    max = Math.max(max, sb.length());
                }
            }else {
                map.clear();
                sb = new StringBuilder();
                sb.append(word.charAt(i));
                map.put(word.charAt(i),1);
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        String s = "aeeeiiiioooauuuaeiou";
//        int i = longestBeautifulSubstring(s);
//        System.out.println(i);

//        System.out.println((int) Math.pow(2,3));
//        System.out.println(3^2);

        System.out.println(3%6);
    }

}
