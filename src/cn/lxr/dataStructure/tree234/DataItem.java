package cn.lxr.dataStructure.tree234;

public class DataItem {

    public long dData;

    public DataItem (long dData) {
        this.dData = dData;
    }

    public void displayItem() {
        System.out.print("/" + dData);
    }
}
