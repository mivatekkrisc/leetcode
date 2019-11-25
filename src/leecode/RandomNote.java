package leecode;

public class RandomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] counts = new int[26];
        for (char c : magazine.toCharArray())
            counts[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (counts[c - 'a'] == 0) return false;
            else counts[c - 'a']--;
        }

        return true;

    }

    public static void main(String args[]) {
        RandomNote r = new RandomNote();
        System.out.println(r.canConstruct("a", "b"));
        System.out.println(r.canConstruct("aa", "ab"));
        System.out.println(r.canConstruct("aa", "aab"));
    }
}
