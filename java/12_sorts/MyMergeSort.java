/**
 * 归并排序
 */
public class MyMergeSort {
    public static void mergeSort(int[] arr, int b, int e) {
        if (e >= b) {
            return;
        }
        int mid = (b+e)/2;
        mergeSort(arr, b, mid);
        mergeSort(arr, mid+1, e);

        merge(arr, b, mid, e);
    }

    public static void merge(int[] arr, int b, int mid, int e) {
        int[] tmp = new int[e-b+1];
        int i = b;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 找剩余的数据
        int start;
        int end;
        if (i == mid + 1) {
            start = j;
            end = e;
        } else {
            start = i;
            end = mid;
        }
        // 赋值剩余数据到 tmp
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        // 替换arr
        for (int index = 0; index < k; ++index) {
            arr[b+index] = tmp[index];
        }
    }
}
