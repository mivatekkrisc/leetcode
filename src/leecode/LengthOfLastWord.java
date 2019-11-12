package leecode;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;

        int len = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }

        return len;
    }

    public static void main(String args[]) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("Hello World"));
        System.out.println(l.lengthOfLastWord(""));
        System.out.println(l.lengthOfLastWord("hihi"));
        System.out.println(l.lengthOfLastWord("aaaaaa   "));
        System.out.println(l.lengthOfLastWord("   bbbbbbbb   "));
    }
}
