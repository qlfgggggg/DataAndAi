package qiaolf.zuoshen.class04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: 归并排序
 * Author:qiaolf
 * @Date:2021/7/28 19:24
 **/
public class code01_mergeSort2 {


    public static void sort(int[] arr){
        int N = arr.length;
        process(arr,0,N-1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l==r){
            return;
        }
        process(arr,l,l+((r-l)>>1));
        process(arr,l+1+((r-l)>>1),r);
        merge(arr,l,l+((r-l)>>1),r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] res = new int[r-l+1];
        int p = l;
        int q = mid+1;
        int i=0;
        while (p<=mid && q<=r){
            res[i++] = arr[p] >= arr[q] ? arr[q++] : arr[p++];
        }
        while (p<=mid){
            res[i++] = arr[p++];
        }
        while (q<=r){
            res[i++] = arr[q++];
        }
        for (int j = 0; j < res.length; j++) {
            arr[l+j]=res[j];
        }
    }


    public static void sort2(int arr[]){
        if (arr==null || arr.length<2){
            return;
        }
        int mergeSzie = 1;
        int N = arr.length;
        while (mergeSzie<N){
            int L = 0;
            while (L<N){
                int R = L+mergeSzie-1;
                if (R>=N){
                    break;
                }
                int M = Math.min(N-1,R+mergeSzie);
                merge(arr,L,R,M);
                L=M+1;
            }
            if (mergeSzie>N/2){
                break;
            }
            mergeSzie*=2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            arr[i]=r.nextInt(1000);
        }

        sort(arr);
        for (int i = 1000; i >=1000-99 ; i++) {
            System.out.println(arr[i]);
        }
    }

}
