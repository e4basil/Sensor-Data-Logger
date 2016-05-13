package net.steppschuh.datalogger.data;

import java.util.ArrayList;
import java.util.List;

public class DataBatch {

    public static final int CAPACITY_UNLIMITED = -1;
    public static final int CAPACITY_DEFAULT = 200;

    private List<Data> dataList;
    private int capacity;

    public DataBatch() {
        dataList = new ArrayList<>();
        capacity = CAPACITY_DEFAULT;
    }

    public DataBatch(List<Data> dataList) {
        this();
        this.dataList = dataList;
    }

    private void trimDataToCapacity() {
        // check if there's a capacity limit
        if (capacity == CAPACITY_UNLIMITED) {
            return;
        }

        // check if trimming is needed
        if (dataList == null || dataList.size() < capacity) {
            return;
        }

        // remove oldest data
        while (dataList.size() > capacity) {
            dataList.remove(0);
        }
    }

    public void addData(Data data) {
        dataList.add(data);
        trimDataToCapacity();
    }

    public Data getNewestData() {
        if (dataList == null || dataList.size() < 1) {
            return null;
        }
        return dataList.get(dataList.size() - 1);
    }

    public Data getOldestData() {
        if (dataList == null || dataList.size() < 1) {
            return null;
        }
        return dataList.get(0);
    }

    /**
     * Getter & Setter
     */
    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}