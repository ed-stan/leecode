package one;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leecode5_1 {
    public static String longestPalindrome(String s) {
        String maxStr1 = oneChar(s, 0);
        for (int i = 1; i < s.length(); i++) {
            String itemStr = oneChar(s, i);
            if (itemStr.length() > maxStr1.length()) {
                maxStr1 = itemStr;
            }
        }
        String maxStr2="";
        if(s.length()>1){
            maxStr2 = twoChar(s, 0);
            for (int i = 1; i < s.length() - 1; i++) {
                String itemStr = twoChar(s, i);
                if (itemStr.length() > maxStr2.length()) {
                    maxStr2 = itemStr;
                }
            }
        }

        return maxStr1.length() > maxStr2.length() ? maxStr1 : maxStr2;

    }

    private static String oneChar(String s, int index) {
        char c = s.charAt(index);
        String result = String.valueOf(c);
        StringBuffer itemStr = new StringBuffer(s);
        if (index < s.length() / 2) {
            for (int i = 0; i <= index; i++) {
                String theSubstring = itemStr.substring(index - i, index + 1 + i);
                StringBuffer str = new StringBuffer(theSubstring);
                StringBuffer reversestr = str.reverse();
                if (theSubstring.equals(reversestr.toString())) {
                    result = theSubstring;
                }
            }
        } else {
            for (int i = 0; i < s.length() - index; i++) {
                String theSubstring = itemStr.substring(index - i, index + 1 + i);
                StringBuffer str = new StringBuffer(theSubstring);
                StringBuffer reversestr = str.reverse();
                if (theSubstring.equals(reversestr.toString())) {
                    result = theSubstring;
                }
            }
        }
        return result;
    }

    private static String twoChar(String s, int index) {
        String result=null;
        if(s.charAt(index)==s.charAt(index+1)){
            result = s.substring(index, index + 2);
        }else {
            result="";
        }

        StringBuffer itemStr = new StringBuffer(s);
        if (index < s.length() / 2) {
            for (int i = 0; i <= index; i++) {
                String theSubstring = itemStr.substring(index - i, index + 2 + i);
                StringBuffer str = new StringBuffer(theSubstring);
                StringBuffer reversestr = str.reverse();
                if (theSubstring.equals(reversestr.toString())) {
                    result = theSubstring;
                }
            }
        } else {
            for (int i = 0; i < s.length() - index - 1; i++) {
                String theSubstring = itemStr.substring(index - i, index + 2 + i);
                StringBuffer str = new StringBuffer(theSubstring);
                StringBuffer reversestr = str.reverse();
                if (theSubstring.equals(reversestr.toString())) {
                    result = theSubstring;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = longestPalindrome("a");
        System.out.println(str);


    }
}
