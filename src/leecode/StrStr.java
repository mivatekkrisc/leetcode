package leecode;

public class StrStr {

    public int strStr(String haystack, String needle) {

        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (j < needle.length() && i + j < haystack.length() && needle.charAt(j) == haystack.charAt(i + j))
                j++;

            if (j == needle.length())
                return i;
        }
        return -1;

    }

    public static void main(String args[]) {
        StrStr s = new StrStr();
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("aaaaa", "bba"));
        System.out.println(s.strStr("aaa", "aaaa"));
    }
}
