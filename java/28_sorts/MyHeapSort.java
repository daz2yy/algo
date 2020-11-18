
import java.util.Arrays;

public class MyHeapSort {
    // 1. left: 2*i, right: 2*i + 1, parent: i

    // ����������
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 1. ����
        buildHeap(arr);
        // 2. ����
        int count = arr.length - 1;
        while (count > 0) {
            MyHeapSort.swap(arr, 0, count);
            heapify(arr, --count, 0);
        }
    }

    // ����
    public static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 Ϊ���һ��Ҷ�ӽڵ�ĸ��ڵ�
        // Ҳ�������һ����Ҷ�ӽڵ㣬���ζѻ�ֱ�����ڵ�
        int n = (arr.length-1) / 2;
        while (n >= 0) {
            heapify(arr, arr.length-1, n);
            n--;
        }
    }

    // �ѻ�����������
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
