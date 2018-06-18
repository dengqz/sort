package mergesort;

/**
 * 归并排序
 * Created by cheese on 2018/6/18.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 9, 8, 5, 4, 6};
        array = mergeSort(array,0,7);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public  static int[] mergeSort(int[] a, int left, int right) {
        int t = 1;// 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;// 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge(a, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                merge(a, i, i + (s - 1), right);
        }
        return a;
    }
    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];
        for (int i = p; i <= r; i++)
            data[i] = B[i];
    }
}
