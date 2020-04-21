package cn.lxr.dataStructure.test;

import cn.lxr.dataStructure.binaryTree.BinaryTree;
import cn.lxr.dataStructure.binaryTree.Node;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50, 1.5);
        tree.insert(70, 1.1);
        tree.insert(20, 1.8);
        Node node = tree.find(20);
        node.displayNodeKey();

    }


}
