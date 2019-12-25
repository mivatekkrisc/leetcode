package leecode;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        if(s == null || s.length() == 0) return 0;

        int result = 0;
        int[] counts = new int[64];
        for(int i = 0 ; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            counts[index]++;
            if(counts[index] == 2) {
                result += 2;
                counts[index] = 0;
            }
        }
        for(int i = 0; i < counts.length; i++)
            if(counts[i] > 0) {
                result++;
                break;
            }
        return result;
    }

    public static void main(String args[]) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("abccccdd"));
        System.out.println(l.longestPalindrome("AAAAAA"));
        System.out.println(l.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));

    }
}
