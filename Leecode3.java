package one;

import java.util.*;

public class Leecode3 {


    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.get(c) != null) {
                list.add(queue.size());
                while (map.get(c) != null) {
                    Character poll = queue.poll();
                    map.remove(poll);
                }
            }
            map.put(c, 1);
            queue.offer(c);
        }
        list.add(queue.size());
        if (list.isEmpty()) {
            result = queue.size();
        } else {
            result = list.get(0);
            for (int i : list) {
                if (i > result) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("aab");
        System.out.println(a);
    }
}
