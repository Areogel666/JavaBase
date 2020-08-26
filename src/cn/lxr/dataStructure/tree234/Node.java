package cn.lxr.dataStructure.tree234;

public class Node {

    public static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node[] childArray = new Node[ORDER];
    private DataItem[] itemArray = new DataItem[ORDER - 1];

    /**
     * 链接子节点
     * @param childNum
     * @param child
     */
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * 断开子节点
     * @param childNum
     * @return
     */
    public Node disconnectChild(int childNum) {
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean isLeaf() {
        return (childArray[0] == null);
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return (numItems == ORDER - 1);
    }

    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].dData == key) {
                return j;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.dData;
        for (int j = ORDER - 2; j >= 0 ; j--) {
            if (itemArray[j] == null) {
                continue;
            }
            long itsKey = itemArray[j].dData;
            if (newKey < itsKey) {
                // 数据右移
                itemArray[j + 1] = itemArray[j];
            } else {
                itemArray[j + 1] = newItem;
                return j + 1;
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }
}
