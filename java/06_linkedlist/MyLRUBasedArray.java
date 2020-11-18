package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class MyLRUBasedArray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);
    private T[] data;
    private int capacity;
    private int count;
    private Map<T, Integer> hash; // 数值越大，越早之前使用，0是最近一次使用

    public MyLRUBasedArray(int capacity) {
        data = (T[]) new Object[capacity];
        this.capacity = capacity;
        count = 0;
        hash = new HashMap<T, Integer>(capacity);
    }
    public MyLRUBasedArray() { this(DEFAULT_CAPACITY); }

    /**
     * 模拟访问某个值
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("object is illegal");
        }
        Integer index = hash.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有对应的值，更新数值
     * @param end
     */
    public void update(int end) {
        T target = data[end];
        rightShift(end);
        data[0] = target;
        hash.put(target, 0);
    }

    /**
     * 缓存数据到头部，但要先右移？
     * @param object
     * @param end
     */
    public void cache(T object, int end) {
        rightShift(end);
        data[0] = object;
        hash.put(object, 0);
        count++;
    }

    /**
     * 缓存满了之后，先踢出一个元素，再缓存到头部
     * @param object
     */
    public void removeAndCache(T object) {
        T target = data[--count];
        hash.remove(target);
        cache(object, count);
    }

    /**
     * 位置 end 左边的数据统一右移一位
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; --i) {
            data[i+1] = data[i];
            // hash.get(data[i]) + 1 == i + 1
            hash.put(data[i], hash.get(data[i]) + 1);
        }
    }

    public boolean isContain(T object) { return hash.containsKey(object); }
    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return data.length == capacity; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T object : data) {
            sb.append(object).append(" ");
        }
        return sb.toString();
    }
}
