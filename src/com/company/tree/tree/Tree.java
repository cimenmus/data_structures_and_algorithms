package com.company.tree.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    Node root;

    public static class Node {

        int value;
        Node parent;
        List<Node> children;

        public Node(int value){
            this.value = value;
            parent = null;
            children = new ArrayList<>();
        }

        public void setParent(Node node){
            this.parent = node;
        }

        public void addChild(Node node){
            node.parent = this;
            children.add(node);
        }

        public void addChildren(List<Node> nodes){
            for (Node node: nodes){
                node.parent = this;
                children.add(node);
            }
        }
    }
}
