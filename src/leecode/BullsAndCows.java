package leecode;

import java.util.*;

public class BullsAndCows {

    public String getHint(String secret, String guess) {

        Set<Integer> aIndex = new HashSet<Integer>();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i))
                aIndex.add(i);
            else {
                if(map.containsKey(secret.charAt(i)))
                    map.put(secret.charAt(i), map.get(secret.charAt(i))+1);
                else
                    map.put(secret.charAt(i), 1);
            }
        }

        int bCount = 0;
        for(int i = 0 ; i < guess.length(); i++) {
            Integer count = map.get(guess.charAt(i));
            if(!aIndex.contains(i) && count != null) {
                bCount++;
                if(count == 1) map.remove(guess.charAt(i));
                else map.put(guess.charAt(i), count-1);
            }
        }
        return String.format("%dA%dB", aIndex.size(), bCount);
    }

    public static void main(String args[]) {
        BullsAndCows b = new BullsAndCows();
        System.out.println(b.getHint("1807", "7810"));
        System.out.println(b.getHint("1122", "2211"));
    }
}
