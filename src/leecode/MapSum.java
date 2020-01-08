package leecode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private static class Node {
        char ch;

        Map<Character, Node> children = new HashMap<>();
        int value = -1;

        public Node(char ch, int value) {
            this.ch = ch;
            this.value = value;
        }

        public Node getChildren(char ch) {
            return children.get(ch);
        }

        public void addChildren(char ch, Node child) {
            children.put(ch, child);
        }

        public void setValue(int val) {
            this.value = val;
        }
    }

    Node root = new Node(' ', 0);

    public MapSum() {

    }

    public void insert(String key, int val) {
        Node current = root;
        int index = 0;
        while (index < key.length()) {
            Node child = current.getChildren(key.charAt(index));

            if (child == null) {
                int value = index == key.length() - 1 ? val : -1;
                child = new Node(key.charAt(index), value);
                current.addChildren(key.charAt(index), child);
            } else {
                int value = index == key.length() - 1 ? val : child.value;
                child.setValue(value);
            }

            index++;
            current = child;

        }

    }

    public int sum(String prefix) {

        int index = 0;
        int result = 0;
        Node current = root;
        while (index < prefix.length()) {
            Node child = current.getChildren(prefix.charAt(index));
            if(child == null)
                return result;

            index++;
            current = child;
        }

        if (current.value != -1)
            result += current.value;
        return dfs(current, result);
    }

    public int dfs(Node node, int result) {
        if (node.children.values() != null) {
            for (Node child : node.children.values()) {
                if (child.value != -1)
                    result += child.value;
                result = dfs(child, result);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        MapSum m = new MapSum();
//        m.insert("aa", 2);
//        m.insert("aaa", 3);
//        System.out.println(m.sum("aa"));
        m.insert("aa", 3);
        System.out.println(m.sum("a"));
        m.insert("aa", 2);
        System.out.println(m.sum("a"));
        System.out.println(m.sum("aa"));
        m.insert("aaa", 3);
        System.out.println(m.sum("aaa"));
        System.out.println(m.sum("bbb"));
        System.out.println(m.sum("ccc"));
        m.insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj", 111);
        System.out.println(m.sum("aa"));
        System.out.println(m.sum("a"));
    }


}
