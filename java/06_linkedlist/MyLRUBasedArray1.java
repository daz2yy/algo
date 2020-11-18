import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少使用队列
 * 1. 新增数据
 * 2. 更新数据
 * 3. 数据满了，删除后更新
 * 4. 模拟访问数据
 *
 * 错误：
 * 0. new 泛型数组的写法！
 * 1. rightshift 的时候要更新 hash 的值
 * 2. 要写泛型对象
 * 3. arr 数组是 LRU 队列，不是预先存在的数据队列
 * 4. removeAndCache，没有删除，没有cache
 * 5. update 没有更新 arr
 * 用了20分钟
 */
public class MyLRUBasedArray1<T> {
    private T[] data;
    private int count;
    private int capacity;
    private Map<T, Integer> hash;

    public MyLRUBasedArray1(int cap) {
        data = (T[]) new Object[cap];
        count = 0;
        capacity = cap;
        hash = new HashMap<>(cap);
    }

    public void offer(T object) {
        if (hash.get(object) == null) {
            cache(object);
        } else {
            if (count == capacity) {
                removeAndCache(object);
            } else {
                update(object);
            }
        }
    }

    public void cache(T object) {
        rightShift(count);
        data[0] = object;
        hash.put(object, 0);
        ++count;
    }

    public void update(T object) {
        rightShift(hash.get(object));
        data[0] = object;
        hash.put(object, 0);
    }

    public void removeAndCache(T object) {
        hash.remove(data[count-1]);
        count--;
        cache(object);
    }

    public void rightShift(int end) {
        while (end > 0) {
            data[end] = data[end-1];
            hash.put(data[end], hash.get(data[end-1]));
        }
    }
}
