package com;

import java.util.ArrayList;
import java.util.List;
/*
给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。

 */
public class Demo {
    public static int lastRemaining(int n) {
        List<Integer> list =new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            list.add(i);
        }
        int l;
        int r;
        while (list.size()!=1){
            l=0;
            while (l<list.size()){
                list.remove(l);
                l=l+1;
                System.out.println("l:"+l+"-----"+"len:"+list.size());
            }
            if (list.size()==1) {
                break;
            }
            int i=1;
            r=list.size()-i;
            while (r>=0){
                list.remove(r);
                i++;
                r=list.size()-i;
                System.out.println("r:"+r+"-----"+"len:"+list.size());
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int i = lastRemaining(1322);
        System.out.println(i);
    }
}
