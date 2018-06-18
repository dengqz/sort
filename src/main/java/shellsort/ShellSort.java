package shellsort;

/**
 * 希尔排序
 * Created by cheese on 2018/6/18.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 9, 8, 5, 4, 6};
        array = sheelSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] sheelSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){//分组
                for(int j=i+len;j<a.length;j+=len){//元素从第二个开始
                    int k=j-len;//k为有序序列最后一位的位数
                    int temp=a[j];//要插入的元素
                    /*for(;k>=0&&temp<a[k];k-=len){
                        a[k+len]=a[k];
                    }*/
                    while(k>=0&&temp<a[k]){//从后往前遍历
                        a[k+len]=a[k];
                        k-=len;//向后移动len位
                    }
                    a[k+len]=temp;
                }
            }
        }
        return a;
    }
}
