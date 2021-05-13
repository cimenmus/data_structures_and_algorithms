package com.company.tree.tree;

import java.util.Random;

public class Exercises {

    public static void main(String[] args) {
        Tree tree = createTree();

    }

    //region Traversing
    // Deep First Traversal
    public static void traverseDeepFirst(Tree.Node node, String appender){
        System.out.println(appender + node.value);
        //node.children.forEach(child -> traverse(child, appender + appender));
        for (Tree.Node child: node.children){
            traverseDeepFirst(child, appender + appender);
        }
    }
    //endregion

    private static Tree createTree(){
        Tree.Node root = new Tree.Node(getRandom());

        Tree.Node node1 = new Tree.Node(getRandom());
        root.addChild(node1);

        Tree.Node node11 = new Tree.Node(getRandom());
        node1.addChild(node11);

        Tree.Node node111 = new Tree.Node(getRandom());
        node11.addChild(node111);

        Tree.Node node112 = new Tree.Node(getRandom());
        node11.addChild(node112);

        Tree.Node node12 = new Tree.Node(getRandom());
        node1.addChild(node12);

        Tree.Node node2 = new Tree.Node(getRandom());
        root.addChild(node2);

        Tree.Node node21 = new Tree.Node(getRandom());
        node2.addChild(node21);

        Tree.Node node211 = new Tree.Node(getRandom());
        node2.addChild(node211);

        Tree tree = new Tree();
        tree.root = root;

        traverseDeepFirst(tree.root, "--");

        return tree;
    }

    private static int getRandom(){
        Random random = new Random();
        return random.nextInt(100);
    }

}
