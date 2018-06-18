package quicksort;

/**
 * 快速排序
 * Created by cheese on 2018/6/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 9, 8, 5, 4, 6};
        array = quickSort(array,0,7);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static int[] quickSort(int[]a,int start,int end){
        if(start<end){
            int baseNum=a[start];//选基准值
            int midNum;//记录中间值
            int i=start;
            int j=end;
            do{
                while((a[i]<baseNum)&&i<end){
                    i++;
                }
                while((a[j]>baseNum)&&j>start){
                    j--;
                }
                if(i<=j){
                    midNum=a[i];
                    a[i]=a[j];
                    a[j]=midNum;
                    i++;
                    j--;
                }
            }while(i<=j);
            if(start<j){
                quickSort(a,start,j);
            }
            if(end>i){
                quickSort(a,i,end);
            }
        }
        return a;
    }
}
