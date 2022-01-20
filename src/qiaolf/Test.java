package qiaolf;

import java.util.Random;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/9/8 10:02
 **/
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            arr[i]=r.nextInt(1000);
        }

        sort(arr);
        for (int i = 1000000-1; i >=1000000-99 ; i--) {
            System.out.println(arr[i]);
        }

    }

    public static void sort(int arr[]){
        if (arr==null || arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l==r){
            return;
        }
        process(arr,l,l+((r-l)>>1));
        process(arr,l+((r-l)>>1)+1,r);
        merge(arr,l,l+((r-l)>>1),r);
    }

    private static void merge(int[] arr, int l, int M, int r) {
        int tem[] = new int[r-l+1];
        int i=0;
        int q=l,p=M+1;
        while (q<=M && p<=r){
            if (arr[q]<=arr[p]){
                tem[i++]=arr[q++];
            }else{
                tem[i++]=arr[p++];
            }
        }
        while (q<=M){
            tem[i++]=arr[q++];
        }
        while (p<=r){
            tem[i++]=arr[p++];
        }
        for (i = 0; i < tem.length; i++) {
            arr[l+i]=tem[i];
        }
    }
}
