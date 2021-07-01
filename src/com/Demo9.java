package com;
import java.util.HashSet;
import java.util.Set;
/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
 */
public class Demo9 {
    public static String longestCommonPrefix(String[] strs) {
        Set<String> set=new HashSet();
        int min=strs[0].length();
        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
            }
        }
        String res="",str="";
        for (int i = 0; i < min; i++) {
            for (String s : strs) {
                str = String.valueOf(s.charAt(i));
                set.add(str);
            }
            if(set.size()==1){
                res+=str;
                set.clear();
            }else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","floght"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
