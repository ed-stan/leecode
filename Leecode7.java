package one;

public class Leecode7 {
    public static int reverse(int x) {
        try {
            String str = String.valueOf(x);
            if (x<0){
                str = str.substring(1, str.length());
            }
            StringBuffer stringBuffer =new StringBuffer(str);
            StringBuffer reverse = stringBuffer.reverse();
            int i = Integer.parseInt(reverse.toString());
            if (x<0){
                i=-i;
            }
            return i;
        }catch (Exception e){
            return 0;
        }

    }

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }
}
