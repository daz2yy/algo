package Algorithm;

public class MyGenericArray<T> {
    private T[] data;
    private int size;

    public MyGenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = capacity;
    }

    // 默认构造10个大小
    public MyGenericArray() { this(10); }

    // 基本方法
    // 获取容量大小
    public int getCapacity() {
        return data.length;
    }
    // 获取当前个数
    public int count() {
        return size;
    }

    // 添加指定位置的元素
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
        for (int i = size; i > index; --i) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size++;
    }
    // 在队头添加元素
    public void addFirst(T value) { this.add(value, 0); }
    // 在队尾添加元素
    public void addLast(T value) { this.add(value, size); }

    // 删除指定位置的元素
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed! Require index >= 0 and index < size");
        }
        for (int i = index-1; i < size-1; ++i) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
    }
    // 删除队头
    public void deleteFirst() { this.delete(0); }
    // 删除队尾
    public void deleteLast() { this.delete(size-1); }

    // 修改指定元素的值
    public void modify(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Modify failed! Require index >= 0 and index < size");
        }
        data[index] = value;
    }

    // 获取指定位置的元素
    public T getValue(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed! Require index >= 0 and index < size");
        }
        return data[index];
    }
}






