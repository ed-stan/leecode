package com;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static int lastRemaining(int n) {
        if(n==1)
            return 1;
        int num;
        if(n%2==0)
            num=n ;
        else
            num=n-1;
//        List<Integer> list=new ArrayList<>();
//        for (int i = 2; i <= num; i=i+2) {
//            list.add(i);
//        }

        int head=2;
        int last=num;
        int count=1;
        int size=num/2;

        while (size!=1){
            count++;
            if (size%2==0){
                if (count %2!= 0) {
                    head=(int)Math.pow(2,count-1)+head;
                }
            }else {
                head=(int)Math.pow(2,count-1)+head;
            }
            size=size/2;
            last=(size-1)*(int)Math.pow(2,count)+head;

            if (size==2){
                if (count%2==0){
                    return last;
                }else {
                    return head;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int i = lastRemaining(100000000);
        System.out.println(i);
    }
}

