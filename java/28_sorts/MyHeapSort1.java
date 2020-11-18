import java.util.Arrays;

public class MyHeapSort1 {
    public static void sort(int[] arr) {
        // 1. 建堆
        MyHeapSort1.buildHeap(arr);
        // 2. 排序
        int index = arr.length-1;
        while (index > 0) {
            MyHeapSort1.swap(arr, 0, index--);
            heapify(arr, index, 0);
        }
    }

    public static void buildHeap(int[] arr) {
        // 从最小的父节点开始向上整理每一颗子树
        int index = (arr.length-1)/2;
        while (index >= 0) {
            MyHeapSort1.heapify(arr, arr.length-1, index--);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        while (i < n) {
            int maxPos = i;
            if (2*i + 1 <= n && arr[2*i + 1] > arr[i]) {
                maxPos = 2*i + 1;
            }
            if (2*i + 2 <= n && arr[2*i + 2] > arr[maxPos]) {
                maxPos = 2*i + 2;
            }
            // 不用在向下整理
            if (maxPos == i) {
                return;
            }
            MyHeapSort1.swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 8, 6};
        StringBuffer abc = new StringBuffer("asdf");

        System.out.println("Before sort:" + Arrays.toString(arr));
        MyHeapSort1.sort(arr);
        System.out.println("After sort:" + Arrays.toString(arr));
    }
}
