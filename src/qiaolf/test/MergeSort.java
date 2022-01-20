package qiaolf.test;

/**
 * @Description: 归并排序
 * Author:qiaolf
 * @Date:2021/9/6 17:30
 **/
public class MergeSort {
    public static void main(String[] args) {

    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void sort(int[] arr){
        if (arr==null || arr.length==0){
            return;
        }
        process(arr,0,arr.length-1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l>=r){
            return;
        }
        process(arr,l,l+(r-l)>>1);
        process(arr,l+1+(r-l)>>1,r);
        merge(arr,l,l+(r-l)>>1,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int temp[] = new int[arr.length];
        int i=0;
        int p=l,q=mid+1;
        while (p<=mid && q<=r){
            temp[i++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }

        while (p<=mid){
            temp[i++] = arr[p++];
        }

        while (q<=r){
            temp[i++]=arr[q++];
        }

        for (int j = 0; j < i; j++) {
            arr[l+i]=temp[j];
        }
    }
}
