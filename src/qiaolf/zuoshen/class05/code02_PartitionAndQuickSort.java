package qiaolf.zuoshen.class05;

import java.net.PortUnreachableException;
import java.util.Random;
import java.util.Stack;

/**
 * @Description: 快速排序
 * Author:qiaolf
 * @Date:2021/3/24 20:51
 **/
public class code02_PartitionAndQuickSort {
    public static void swap(int arr[],int i,int j){
        int tem = arr[i];
        arr[i]=arr[j];
        arr[j]=tem;
    }


    public static int[] netherLandFlag(int arr[],int L,int R){
        if (L>R){
            return new int[]{-1,-1};
        }
        if (L==R){
            return new int[]{L,R};
        }
        int less = L-1;
        int more = R;
        int index = L;
        while (index<more){
            if (arr[index]<arr[R]){
                swap(arr,++less,index++);
            }else if (arr[index]==arr[R]){
                index++;
            }else{
                swap(arr,index,--more);
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }

    public static void quickSort3(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        process3(arr,0,arr.length-1);
    }

    private static void process3(int[] arr, int l, int r) {
        if (l>=r){
            return;
        }
        swap(arr,l+(int)(Math.random()*(r-l+1)),r);
        int[] ints = netherLandFlag(arr, l, r);
        process3(arr,l,ints[0]-1);
        process3(arr,ints[1]+1,r);
    }


    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            arr[i]=r.nextInt(1000);
        }

        quickSort3(arr);
        for (int i = 1000000-1; i >=1000000-100 ; i--) {
            System.out.println(arr[i]);
        }
    }
}
