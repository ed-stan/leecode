package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode10 {
    public static boolean isMatch(String s, String p) {
        if (p.contains("*") || p.contains(".")) {
            char[] sChars = s.toCharArray();
            char[] pChars = p.toCharArray();
            List<Character> sList = new ArrayList<>();
            List<Character> pList = new ArrayList<>();
            for (char c : sChars) {
                sList.add(c);
            }
            for (char c : pChars) {
                pList.add(c);
            }
            boolean result = true;
            boolean flag = false;
            for (char c : sChars) {
                while (true) {
                    if (pList.isEmpty()) {
                        result = false;
                        break;
                    }
                    if (pList.get(0) == c || pList.get(0) == '.') {
                        if (pList.size() == 1) {
                            pList.remove(0);
                            break;
                        }
                        if (!flag && pList.get(1) == '*') {
                            flag = true;
                            break;
                        }
                        if (flag) {
                            break;
                        }
                        pList.remove(0);
                        break;
                    } else {
                        if (pList.size() == 1) {
                            return false;
                        }
                        if (pList.get(1) == '*') {
                            pList.remove(0);
                            pList.remove(0);
                            flag = false;
                        } else {
                            if (flag) {
                                flag = false;
                                pList.remove(0);
                                pList.remove(0);
                            } else {
                                result = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (pList.size() >= 3 && pList.get(1) == '*')
                return false;
            return result;
        } else {
            return s.equals(p);
        }
    }

    public static void main(String[] args) {


        boolean result = isMatch("aaa", "a*a");
        System.out.println(result);
    }
}
