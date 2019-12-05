package leecode;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {

        if (s == null || s.length() == 0) return s;

        char[] chs = s.toCharArray();

        int i = 0, j = chs.length - 1;
        while (i < j) {
            while (i < chs.length - 1 && !isVowels(chs[i]))
                i++;
            while (j >= 0 && !isVowels(chs[j]))
                j--;

            if (i < j) {
                char tmp = chs[i];
                chs[i] = chs[j];
                chs[j] = tmp;
            }
            i++;
            j--;
        }
        return new StringBuilder().append(chs).toString();

    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String args[]) {
//        System.out.println(new ReverseVowelsOfAString().reverseVowels("hello"));
//        System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
//        System.out.println(new ReverseVowelsOfAString().reverseVowels("b"));
//        System.out.println(new ReverseVowelsOfAString().reverseVowels("aA"));
        System.out.println(new ReverseVowelsOfAString().reverseVowels(".,"));

    }
}
