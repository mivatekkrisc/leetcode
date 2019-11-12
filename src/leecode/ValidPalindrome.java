package leecode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()) return true;

        int i = 0, j = s.length() - 1;

        while(i < j) {

            while(i < j && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(i))))
                i++;
            while(i < j && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(j))))
                j--;

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;

            i++;
            j--;

        }

        return true;

    }

    public static void main(String args[]) {
        ValidPalindrome v = new ValidPalindrome();
//        System.out.println(v.isPalindrome(""));
//        System.out.println(v.isPalindrome(" "));
//        System.out.println(v.isPalindrome("a"));
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(v.isPalindrome("race a car"));
        System.out.println(v.isPalindrome("0P"));
    }
}
