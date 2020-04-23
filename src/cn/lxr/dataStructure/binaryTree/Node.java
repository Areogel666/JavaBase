package cn.lxr.dataStructure.binaryTree;

public class Node {

    int iData; //key
    double fData; //Other value
    Node leftChild;
    Node rightChild;

    public void displayNode() {
        System.out.print("{");
        System.out.print(iData);
        System.out.print(",");
        System.out.print(fData);
        System.out.println("}");
    }

    public void displayNodeKey() {
        System.out.println(iData);
    }
}
