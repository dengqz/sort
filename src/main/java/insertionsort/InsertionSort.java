package insertionsort;

/**
 * 插入排序（稳定排序）
 * Created by cheese on 2018/6/18.
 */
public class InsertionSort {
    public static void main(String[] args) {
        Integer[] array = {1, 7, 3, 9, 8, 5, 4, 6};
        array = insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static Integer[] sort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            for(int j=i;j>0&&array[j]<array[j-1];j--){
                Integer temp=array[j];
                array[j]=array[j-1];
                array[j-1]=temp;
            }
        }
        return array;
    }
    public static <AnyType extends Comparable<? super AnyType>>
    AnyType[] insertionSort(AnyType[] a){
        int j;
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            for ( j = p; j >0 && tmp.compareTo(a[j-1])<0; j--) {
                a[j] =a[j-1];
            }
            a[j] = tmp;
        }
        return a;
    }
}
//从数组的第二个元素开始遍历，将该元素与前面的元素比较，
// 如果该元素比前面的元素小，将该元素保存进临时变量中，
// 依次将前面的元素后移，然后将该元素插入到合适的位置。
// 每次排序完成后，索引左边的元素一定是有序的，但是还可以移动。
// 对于倒置越少的数组，该算法的排序效率越高
