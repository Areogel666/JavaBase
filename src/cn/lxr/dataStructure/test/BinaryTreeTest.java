package cn.lxr.dataStructure.test;

import cn.lxr.dataStructure.binaryTree.BinaryTree;
import cn.lxr.dataStructure.binaryTree.Node;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTreeTest {

    public static void main (String[] args) throws IOException {
        int value;
        BinaryTree tree = new BinaryTree();
        tree.insert(40, 1.3);
        tree.insert(34, 1.1);
        tree.insert(45, 1.0);
        tree.insert(38, 1.4);
        tree.insert(12, 1.3);
        tree.insert(6, 1.5);
        tree.insert(76, 1.8);
        tree.insert(56, 1.7);
        tree.insert(66, 1.2);
        tree.insert(66, 1.6);

        while (true) {
            System.out.println("Enter first letter of show, insert, find, delete, traverse: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.println("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.println("Enter value to find: ");
                    value = getInt();
                    Node found = tree.find(value);
                    if (found != null) {
                        found.displayNode();
                    } else {
                        System.out.println("Could not find: " + value);
                    }
                    break;
                case 'd':
                    System.out.println("Enter value to delete: ");
                    value = getInt();
                    boolean delete = tree.delete(value);
                    if (delete) {
                        System.out.println("delete " + value + "successful");
                    } else {
                        System.out.println("fail to delete");
                    }
                    break;
                case 't':
                    System.out.println("Enter type 1, 2 or 3: ");
                    value = getInt();
                    tree.traverse(value);
                    break;
                default:
                    return;
            }
        }

    }

    @Test
    public void testFind() {
        BinaryTree tree = new BinaryTree();
        tree.insert(50, 1.5);
        tree.insert(70, 1.1);
        tree.insert(20, 1.8);
        Node node = tree.find(20);
        node.displayNodeKey();
    }

    private static String getString() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        return new BufferedReader(input).readLine();
    }

    private static char getChar() throws IOException {
        return getString().charAt(0);
    }
    private static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
