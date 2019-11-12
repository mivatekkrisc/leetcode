package leecode;

public class IntToRoman {

    public String intToRoman(int x) {

        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0 ; i < values.length; i++) {
            while(x >= values[i]) {
                sb.append(romans[i]);
                x -= values[i];
            }
        }
        return sb.toString();

    }

    public static void main(String args[]) {
        IntToRoman r = new IntToRoman();
        System.out.println(r.intToRoman(3));
        System.out.println(r.intToRoman(4));
        System.out.println(r.intToRoman(9));
        System.out.println(r.intToRoman(58));
        System.out.println(r.intToRoman(1994));
    }
}
