public class MyKthSmallest {

    public static int solve(int arr[], int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }
        int mid = partition(arr, 0, arr.length-1);
        while (mid != k-1) {
            if (mid < k-1) {
                mid = partition(arr, mid+1, arr.length-1);
            } else {
                mid = partition(arr, 0, mid-1);
            }
        }
        return arr[mid];
    }

    // 固定思维了，错误：
    public static int find(int[] arr, int b, int e, int k) {
        if (e >= b) {
            return 0;
        }

        int mid = partition(arr, b, e); // mid是排好序的位置
        if (mid == k) {
            return arr[k];
        }
        if (mid < k) {
            //第 k 小的值在右区域
            return find(arr, mid+1, e, k);
        } else {
            return find (arr, b, mid-1, k);
        }
    }

    public static int partition(int[] arr, int b, int e) {
        int pivot = arr[e];
        int i = b;
        for (int j = b; j < e; ++j) {
            if (arr[j] < pivot) {
                if (i != j) {
                    int mid = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = mid;
                }
            }
        }
        int mid = arr[i];
        arr[i] = arr[e];
        arr[e] = mid;
        return i;
    }
}
