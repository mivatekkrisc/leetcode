package leecode;

public class ReverseString {

    public void reverseString(char[] s) {

        if (s == null || s.length == 0) return;

        int i = 0, j = s.length - 1;

        while (i < j) {

            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String args[]) {
        ReverseString r = new ReverseString();
        char[] input = "Hannah".toCharArray();
        StringBuilder sb = new StringBuilder();
        r.reverseString(input);
        sb.append(input);
        System.out.println(sb.toString());
    }
}
