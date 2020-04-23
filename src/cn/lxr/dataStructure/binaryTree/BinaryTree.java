package cn.lxr.dataStructure.binaryTree;

import java.util.Stack;

public class BinaryTree {

    private Node root;

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (current.iData < key) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 插入
     *
     * @param key
     * @param fData
     */
    public void insert(int key, double fData) {
        Node newNode = new Node();
        newNode.iData = key;
        newNode.fData = fData;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (current.iData < key) {
                    if (current.rightChild == null) {
                        current.rightChild = newNode;
                        return;
                    }
                    current = current.rightChild;
                } else {
                    if (current.leftChild == null) {
                        current.leftChild = newNode;
                        return;
                    }
                    current = current.leftChild;
                }
            }
        }
    }

    /**
     * 删除
     *
     * @param key
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) { // no children
            if (current == root) { // delete root
                root = null;
            } else if (isLeftChild) { // left child
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) { // single left child
            if (current == root) {// delete root
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) { // single right child
            if (current == root) {// delete root
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else { // two children, replace with inorder successor
            Node successor = getSuccessor(current);
            // connect parent of current to successor instead
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            // 此处链接succesor的左分支（右分支已在getSuccessor方法中链接）
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 获取后继节点
     * <p>从delNode的右节点开始搜索，查询key大于delNode的最小节点（即最左子节点）</p>
     *
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        // 将后继节点右子树链接到后继节点父节点的左分支，并将删除节点右子树链接到后继节点右分支
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * 获得最小值
     *
     * @return
     */
    public Node minimum() {
        Node current = root;
        Node miniNode = null;
        while (current != null) {
            miniNode = current;
            current = current.leftChild;
        }
        return miniNode;
    }

    /**
     * 获得最大值
     *
     * @return
     */
    public Node maxmum() {
        Node current = root;
        Node maxNode = null;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    /**
     * 排序访问
     *
     * @param traverseType
     */
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("PreOrder:");
                preOrder(root);
                break;
            case 2:
                System.out.println("InOrder:");
                inOrder(root);
                break;
            case 3:
                System.out.println("PostOrder");
                postOrder(root);
                break;
            default:
                break;
        }
    }

    /**
     * 中序遍历
     * <p>升序遍历：inOrder(root)</p>
     *
     * @param localRoot
     */
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println("localRoot.iData = " + localRoot.iData);
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 前序遍历
     *
     * @param localRoot
     */
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println("localRoot.iData = " + localRoot.iData);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * 后序遍历
     *
     * @param localRoot
     */
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println("localRoot.iData = " + localRoot.iData);
        }
    }

    /**
     * 遍历树
     */
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        boolean isRowEmpty = false;
        System.out.println("..........................................");
        while (!isRowEmpty) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            while (!globalStack.isEmpty()) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                System.out.println();
                while (!localStack.isEmpty()) {
                    Node pop = (Node)localStack.pop();
                    if (pop != null) {
                        globalStack.push(pop);
                    }
                }
                System.out.println("..........................................");
            }
        }
    }
}
