package leecode;

public class ToLowerCase {

    public String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (ch <= 'Z' && ch >= 'A')
                ch = ch + 32;
            sb.append((char) ch);

        }
        return sb.toString();

    }

    public static void main(String args[]) {
        ToLowerCase t = new ToLowerCase();
        System.out.println(t.toLowerCase("Hello"));
        System.out.println(t.toLowerCase("LOVELY"));
    }
}
