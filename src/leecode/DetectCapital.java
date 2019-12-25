package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {

        List<Integer> upperIndex = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)))
                upperIndex.add(i);
        }

        if (upperIndex.size() == word.length() || upperIndex.size() == 0 || (upperIndex.size() == 1 && upperIndex.get(0) == 0))
            return true;
        return false;
    }

    public static void main(String args[]) {
        DetectCapital d = new DetectCapital();
        System.out.println(d.detectCapitalUse("USA"));
        System.out.println(d.detectCapitalUse("leetcode"));
        System.out.println(d.detectCapitalUse("Google"));
    }
}
