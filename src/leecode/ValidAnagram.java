package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0 ; i < c1.length; i++)
            if(c1[i] != c2[i]) return false;

        return true;
//        if(s.length() != t.length()) return false;
//
//        Map<Character, Integer> map = new HashMap<>();
//        for(int i = 0 ; i < s.length(); i++) {
//            Integer count = map.get(s.charAt(i));
//            if(count == null)
//                map.put(s.charAt(i), 1);
//            else
//                map.put(s.charAt(i), map.get(s.charAt(i))+1);
//        }
//
//        for(int i = 0; i < t.length(); i++) {
//            Integer count = map.get(t.charAt(i));
//            if(count == null) {
//                return false;
//            }
//            else if(count == 1) map.remove(t.charAt(i));
//            else map.put(t.charAt(i), count-1);
//        }
//
//        return map.isEmpty();
    }

    public static void main(String args[]) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("anagram", "nagaram"));
        System.out.println(v.isAnagram("rat","car"));
    }
}
