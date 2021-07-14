package one;

//2147483647
public class Leecode8 {
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.equals(""))
            return 0;

        StringBuffer result = new StringBuffer();
        if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-' || s.charAt(0) == '+') {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    result.append(s.charAt(i));
                    if (result.length() >=10) {
                        long aLong = Long.parseLong(result.toString());
                        if (s.charAt(0) == '-') {
                            if (aLong >= 2147483648L) {
                                return -2147483648;
                            }
                        } else {
                            if (aLong > 2147483647) {
                                return 2147483647;
                            }
                        }
                    }
                } else {
                    if (i > 0) {
                        break;
                    }
                }
            }
            if (result.toString().equals("")) {
                return 0;
            }
            if (s.charAt(0) == '-') {
                return -Integer.parseInt(result.toString());
            } else {
                return Integer.parseInt(result.toString());
            }

        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int i = myAtoi("-2147483648");

        System.out.println(i);
    }
}
