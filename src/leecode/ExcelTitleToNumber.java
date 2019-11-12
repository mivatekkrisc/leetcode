package leecode;

public class ExcelTitleToNumber {

    public int titleToNumber(String s) {
        int result = 0;

        int times = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'A' + 1;
            result += val * Math.pow(26, times);
            times++;
        }
        return result;
    }

    public static void main(String args[]) {
        ExcelTitleToNumber e = new ExcelTitleToNumber();
        System.out.println(e.titleToNumber("A"));
        System.out.println(e.titleToNumber("AB"));
        System.out.println(e.titleToNumber("ZY"));
    }
}
