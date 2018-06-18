package mergesort;

/**
 * 归并排序（稳定排序）
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
//归并排序是建立在归并操作上的一种有效的排序算法。
// 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
//首先考虑下如何将将二个有序数列合并。
// 这个非常简单，只要从比较二个数列的第一个数，谁小就先取谁，
// 取了后就在对应数列中删除这个数。然后再进行比较，
// 如果有数列为空，那直接将另一个数列的数据依次取出即可。

//可以看出合并有序数列的效率是比较高的，可以达到O(n)。
//解决了上面的合并有序数列问题，再来看归并排序，其的基本思路就是将数组分成二组A，B，
// 如果这二组组内的数据都是有序的，那么就可以很方便的将这二组数据进行排序。
// 如何让这二组组内数据有序了？

//可以将A，B组各自再分成二组。
// 依次类推，当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序，
// 然后再合并相邻的二个小组就可以了。这样通过先递归的分解数列，
// 再合并数列就完成了归并排序