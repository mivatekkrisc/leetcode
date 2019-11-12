package leecode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int result = 0;
        int index = 0;
        while (index < s.length()) {
            if (index + 1 < s.length()) {
                if (map.containsKey(s.substring(index, index + 2))) {
                    result += map.get(s.substring(index, index + 2));
                    index += 2;
                    continue;
                }
            }
            if(map.containsKey(s.substring(index, index+1))) {
                result += map.get(s.substring(index, index+1));
            }
            index++;
        }

        return result;

    }

    public static void main(String args[]) {
        RomanToInt r = new RomanToInt();
        System.out.println(r.romanToInt("III"));
        System.out.println(r.romanToInt("IV"));
        System.out.println(r.romanToInt("IX"));
        System.out.println(r.romanToInt("LVIII"));
        System.out.println(r.romanToInt("MCMXCIV"));
    }
}
