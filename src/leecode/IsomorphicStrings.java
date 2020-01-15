package leecode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);

            Character target = map.get(c);
            Character reverseTarget = reverseMap.get(c2);
            if (target == null && reverseTarget == null) {
                map.put(c, c2);
                reverseMap.put(c2, c);
            } else if (target != null && c2 != target)
                return false;
            else if (reverseTarget != null && c != reverseTarget)
                return false;
        }
        return true;

    }

    public static void main(String args[]) {
        IsomorphicStrings i = new IsomorphicStrings();
        System.out.println(i.isIsomorphic("egg", "add"));
        System.out.println(i.isIsomorphic("foo", "bar"));
        System.out.println(i.isIsomorphic("paper", "title"));
        System.out.println(i.isIsomorphic("ab", "aa"));
    }
}
