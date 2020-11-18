/**
 * 快排
 */
public class MyQuickSort {
    public static void quickSort(int[] arr, int b, int e) {
        if (e >= b) {
            return;
        }

        int mid = partition(arr, b, e);
        quickSort(arr, b, mid-1);
        quickSort(arr, mid+1, e);
    }

    /**
     * 取巧：分左右区域，左边排序，右边未排序
     * @param arr
     * @param b
     * @param e
     * @return
     */
    public static int partition(int[] arr, int b, int e) {
        int pivot = arr[e];
        int i = b;
        int j = i;
        for (; j < e; ++j) {
            if (arr[j] < pivot) {
                if (i != j) {
                    swap(arr, i, j);
                }
                ++i;
            }
        }
        swap(arr, i, j);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
