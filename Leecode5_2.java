package one;

/**
 * 回文中间相同的字符可以看成一个整体，这样就不用一个一个暴力破解
 * 通过向两边扩散比较，并且转换为数组后我们只需要得到下标位置即可（我们最终只要一串字符串，而不是许多无用的stringbuffer或者别的）
 * 复杂度： n*log（n）
 * 长度可以用打擂台存最大的方式，这样避免了最后要将所有数据再比较一次
 */


public class Leecode5_2 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        //    查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        //  定位中间部分的最后一个字符
        int ans = high;
        //  从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //  记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = longestPalindrome("bcaacb");
        System.out.println(str);


    }
}
