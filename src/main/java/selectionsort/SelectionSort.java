package selectionsort;

/**
 * 选择排序（不稳定的排序方法）
 * Created by cheese on 2018/6/18.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 9, 8, 5, 4, 6};
        array = sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[temp] > array[j]) {
                    temp = j;
                }
            }
            int t = array[temp];
            array[temp] = array[i];
            array[i] = t;
        }
        return array;
    }
}
//等待排序的数组中选择一个最小的元素，将它与数组的第一个位置的元素交换位置。
// 然后从剩下的元素中选择一个最小的元素，将它与第二个位置的元素交换位置，
// 如果最小元素就是该位置的元素，就将它和自身交换位置，依次类推，直到排序完成。