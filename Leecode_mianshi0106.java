package leecode;

import java.util.HashMap;
import java.util.Map;

public class Leecode_mianshi0106 {
    public static String compressString(String S) {
        if(S.equals(""))
            return S;
        int l=0,s=1;
        int sum=1;
        String res="";
        while (l<S.length()&&s<S.length()){
            if(S.charAt(l)==S.charAt(s)){
                s++;
                sum++;
            }else {
                res+=S.charAt(l)+"";
                res+=sum+"";
                sum=1;
                l=s;
                s=l+1;
            }
        }
        res+=S.charAt(l)+"";
        res+=sum+"";
        return res.length()>=S.length()?S:res;
    }

    public static void main(String[] args) {
        System.out.println(compressString(""));
    }
}
