package qiaolf.test;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @Description: 快排
 * Author:qiaolf
 * @Date:2021/9/6 17:53
 **/
public class FastSort {


    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //荷兰国旗问题:左侧都是小于某个输的，右侧都是大于某个数的，中间都是等于的
    public int[] netLand(int arr[],int L,int R){
        if (L>R){
            return new int[]{-1,-1};
        }
        if (L==R){
            return new int[]{L,R};
        }
        int less = L-1;
        int more = R;
        int index = L;
        while (index< more){//index往右，more往左
            if (arr[index]<arr[R]){
                swap(arr,++less,index++);
            }else if (arr[index]==arr[R]){
                index++;
            }else{
                swap(arr,index,--more);
            }
        }
        swap(arr,R,more);
        return new int[]{less+1,more};
    }


    public int[] fastSort(int arr[]){
        if (arr.length==0 || arr==null){
            return null;
        }
        return process(arr,0,arr.length-1);
    }

    private int[] process(int[] arr, int l, int r) {
        if (l>r){
            return null;
        }
        swap(arr,l+(int) Math.random()*(r-l+1),r);
        int[] ints = netLand(arr, l, r);
        process(arr,l,ints[0]-1);
        process(arr,ints[1]+1,r);
        return arr;
    }
}
