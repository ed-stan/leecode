package com;

import java.util.HashSet;
import java.util.Set;

public class Demo5 {
    public static String[] permutation(String s) {
        char[] array = s.toCharArray();
        boolean[] flags=new boolean[array.length];
        Set<String> list=new HashSet();
        dfs(array,flags,list,"");
        return list.toArray(new String[0]);
    }

    public static void dfs(char[] array,boolean[] flags,Set<String> list,String s){
        if(s.length()==array.length){
            list.add(s);
            return;
        }
        for (int i = 0; i <array.length; i++) {
            if(flags[i]){
                continue;
            }
            flags[i]=true;
            dfs(array,flags,list,s+array[i]);
            flags[i]=false;
        }
    }

    public static void main(String[] args) {
        String[] abcs = permutation("abc");
        for (String s:abcs) {
            System.out.println(s);
        }
    }
}
