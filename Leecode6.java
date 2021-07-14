package one;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//中间所隔字符个数：（n-2）·2+1
//第一行：s.length%([（n-2）·2+1]+1)==0
public class Leecode6 {
    public static String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        Map<String, List<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i + "", new ArrayList<>());
        }
        char[] chars = s.toCharArray();
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (flag) {
                map.get(index + "").add(chars[i]);
                if (index == numRows - 1) {
                    flag = false;
                    index--;
                } else
                    index++;

            } else {
                map.get(index + "").add(chars[i]);
                if (index == 0) {
                    flag = true;
                    index++;
                } else
                    index--;
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < map.get(i + "").size(); j++) {
                result.append(map.get(i + "").get(j));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = convert("AB", 1);
        System.out.println(str);
    }
}
