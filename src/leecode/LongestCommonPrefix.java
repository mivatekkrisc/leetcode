package leecode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int i = 0;
        for (i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && strs[0].charAt(i) != strs[j].charAt(i))
                    return strs[0].substring(0, i);
                else if(i >= strs[j].length())
                    return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, i);

    }

    public static void main(String args[]) {
        LongestCommonPrefix l = new LongestCommonPrefix();
//        System.out.println(l.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(l.longestCommonPrefix(new String[] {"dog", "racecar" , "car"}));
//        System.out.println(l.longestCommonPrefix(new String[]{"a"}));
//        System.out.println(l.longestCommonPrefix(new String[]{"c", "c"}));
        System.out.println(l.longestCommonPrefix(new String[] {"aa", "a"}));
    }
}
