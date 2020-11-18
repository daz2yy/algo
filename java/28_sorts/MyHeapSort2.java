public class MyHeapSort2 {
    public void solve(int[] arr) {
        // 1. bulid
        buildHeap(arr);
        // 2. sort
        int n = arr.length-1;
        while(n > 0) {
            swap(arr, n--, 0);
            heapify(arr, n, 0);
        }
    }

    public void buildHeap(int[] arr) {
        int i = (arr.length-1) / 2;
        while (i >= 0) {
            heapify(arr, arr.length-1, i--);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        while (true) {
            int max = arr[i];
            if (2*i + 1 <= n && arr[2*i+1] > arr[max]) {
                max = 2*i+1;
            }
            if (2*i + 2 <= n && arr[2*i+2] > arr[max]) {
                max = 2*i+2;
            }
            if (max == i) {
                break;
            }
            swap(arr, max, i);
            i = max;
        }
    }
}
