package leecode;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {

        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (char c : s.toCharArray())
            chars1[c - 'a']++;

        for (char c : t.toCharArray()) {
            chars2[c - 'a']++;
            if (chars2[c - 'a'] > chars1[c - 'a'])
                return c;
        }
        return 'a';
    }

    public static void main(String args[]) {
        FindTheDifference f = new FindTheDifference();
        System.out.println(f.findTheDifference("abcd", "abcde"));
    }
}
