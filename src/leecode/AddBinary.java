package leecode;

public class AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = 0;
        while (i < a.length() || i < b.length()) {
            int i1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0': 0;
            int i2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0': 0;
            int sum = i1 + i2 + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i++;
        }
        if(carry > 0)
            sb.insert(0, 1);

        return sb.toString();
    }

    public static void main(String args[]) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("11", "1"));
        System.out.println(a.addBinary("1010", "1011"));
    }
}
