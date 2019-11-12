package leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int result = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while(i < s.length() && j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String args[]) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
}
