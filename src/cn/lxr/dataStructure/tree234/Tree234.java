package cn.lxr.dataStructure.tree234;

public class Tree234 {

    private Node root = new Node();

    /**
     * 查询
     * @param key
     * @return
     */
    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1) {
                return childNumber;
            } else if (curNode.isLeaf()) {
                return -1;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    /**
     * 查询下一个大于key的节点
     * @param curNode
     * @param key
     * @return
     */
    public Node getNextChild(Node curNode, long key) {
        int j;
        int numItems = curNode.getNumItems();
        for (j = 0; j < numItems; j++) {
            if (key < curNode.getItem(j).dData) {
                return curNode.getChild(j);
            }
        }
        return curNode.getChild(j);
    }

    
}
