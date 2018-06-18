package bubblesort;

/**
 * 冒泡排序
 * Created by cheese on 2018/6/18.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 9, 8, 5, 4, 6};
        array = sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
