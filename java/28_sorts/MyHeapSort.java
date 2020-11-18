
import java.util.Arrays;

public class MyHeapSort {
    // 1. left: 2*i, right: 2*i + 1, parent: i

    // 堆排序，最大堆
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 1. 建堆
        buildHeap(arr);
        // 2. 排序
        int count = arr.length - 1;
        while (count > 0) {
            MyHeapSort.swap(arr, 0, count);
            heapify(arr, --count, 0);
        }
    }

    // 建堆
    public static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        int n = (arr.length-1) / 2;
        while (n >= 0) {
            heapify(arr, arr.length-1, n);
            n--;
        }
    }

    // 堆化，从下往上
    public static void heapify(int[] arr, int n, int index) {
        while (true) {
            int maxPos = index;
            if (index * 2 + 1 <= n && arr[index*2+1] > arr[index]) {
                maxPos = index * 2 + 1;
            }
            if (index * 2 + 2 <= n && arr[index*2+2] > arr[maxPos]) {
                maxPos = index * 2 + 2;
            }
            if (maxPos == index) {
                break;
            }
            MyHeapSort.swap(arr, maxPos, index);
            index = maxPos;
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
//        int mid = arr[pos1];
//        arr[pos1] = arr[pos2];
//        arr[pos2] = mid;

        arr[pos1] = arr[pos1] + arr[pos2];
        arr[pos2] = arr[pos1] - arr[pos2];
        arr[pos1] = arr[pos1] - arr[pos2];
    }

    public static void main(String args[]) {
        int[] arr = {1, 4, 6, 4, 2, 1};

        System.out.println("before sort: " + Arrays.toString(arr));
        MyHeapSort.sort(arr);
        System.out.println("after sort: " + Arrays.toString(arr));
    }
}
