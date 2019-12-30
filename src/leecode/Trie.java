package leecode;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private static class Node {
        char ch;
        boolean leaf;
        Map<Character, Node> children = new HashMap<>();

        public Node(char ch) {
            this.ch = ch;
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }
    }

    private Node root = new Node(' ');

    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.getChild(word.charAt(i)) != null)
                current = current.getChild(word.charAt(i));
            else {
                Node n = new Node(word.charAt(i));
                current.children.put(word.charAt(i), n);
                current = n;
            }
            if (i == word.length() - 1)
                current.leaf = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.getChild(word.charAt(i)) == null)
                return false;
            current = current.getChild(word.charAt(i));
        }
        if (current.leaf)
            return true;
        return false;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.getChild(prefix.charAt(i)) == null)
                return false;
            current = current.getChild(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
