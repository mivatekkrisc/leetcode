package leecode;

public class AddStrings {

    public String addStrings(String num1, String num2) {

        String longer = num1.length() >= num2.length() ? num1 : num2;
        String shorter = num1.length() < num2.length() ? num1 : num2;

        StringBuilder sb = new StringBuilder();
        int lenDiff = longer.length() - shorter.length();
        int carry = 0;
        for (int i = longer.length() - 1; i >= 0; i--) {
            int ch1 = longer.charAt(i) - '0';
            int ch2 = i - lenDiff >= 0 ? shorter.charAt(i - lenDiff) - '0' : 0;

            int sum = ch1 + ch2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            sb.insert(0, carry);
        return sb.toString();

    }

    public static void main(String args[]) {
        System.out.println(new AddStrings().addStrings("999", "999"));
    }
}
