package com.company.trie;

import java.util.HashMap;
import java.util.List;

public class Trie2 {
    private Character current;
    private HashMap<Character, Trie2> children;

    // Root
    private static Character START = '*';
    // Kelime sonu belirteci
    private static Character END = '$';

    public Trie2(Character _c) {
        current = _c;
        children = new HashMap<>();
    }

    public void addChild(Trie2 child) {
        if(!hasChild(child.current))
            children.put(child.current, child);
    }

    public boolean hasChild(Character _c) {
        return children.containsKey(_c);
    }

    public Trie2 getChildNode(Character _c) {
        return children.get(_c);
    }

    public int getChildCount() {
        return children.size();
    }

    public static Trie2 construct(List<String> str) {
        Trie2 root = new Trie2(Trie2.START);
        for(String s : str) {
            Trie2 currentNode = root;
            // Kelime sonu belirteci ekle
            s = s.concat(Trie2.END.toString());
            for(Character c : s.toCharArray()) {
                if(!currentNode.hasChild(c)) { // Karakter yoksa child olarak ekle
                    Trie2 newNode = new Trie2(c);
                    currentNode.addChild(newNode);
                }
                currentNode = currentNode.getChildNode(c); // Agacta ilerle
            }
        }
        return root;
    }

    public boolean query(String s) {
        Trie2 currentNode = this;
        // Kelime sonu belirteci ekle
        s = s.concat(Trie2.END.toString());
        for(Character c : s.toCharArray()) {
            if (currentNode.hasChild(c)) {
                currentNode = currentNode.getChildNode(c);
            }
            else {
                // Uyusma yoksa false don
                return false;
            }
        }
        // Varsa bile kelime sonu belirteci mi kontrol et
        return currentNode.current.equals(Trie2.END);
    }
}
