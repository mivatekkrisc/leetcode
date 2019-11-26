package leecode;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            int ch = s.charAt(i);

            while (j < t.length() && t.charAt(j++) != ch) ;

            i++;
        }
        return i == s.length() && s.charAt(i-1) == t.charAt(j-1);
    }

    public static void main(String args[]) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "ahbgdc"));
        System.out.println(i.isSubsequence("axc", "ahbgdc"));
        System.out.println(i.isSubsequence("b", "c"));
        System.out.println(i.isSubsequence("acb", "ahbgdc"));
    }
}
