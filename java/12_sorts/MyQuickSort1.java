public class MyQuickSort1 {
    public void qsort(int[] arr, int begin, int end) {
        if (end >= begin) {
            return;
        }

        int middle = partition(arr, begin, end);
        qsort(arr, begin, middle-1);
        qsort(arr, middle+1, end);
    }

    public int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        // 关键：维护左右区间
        int i = begin;
        int j = begin;
        while (j < end) {
            if (arr[j] < pivot) {
                if (i != j) {
                    swap(arr, i, j);
                }
                ++i;
                ++j;
            }
        }
        swap(arr, i, end);
        return i;
    }
}
