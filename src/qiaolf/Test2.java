package qiaolf;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/9/8 14:13
 **/
public class Test2 {
    //一个数组的前100位大的数
    public static int[] max100(int arr[]){
        //思路是求这个数组     [a,b) b (b,c]
        //用快排的思路来解题
        //用小根堆来实现
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.add(arr[i]);
        }
        for (int i = 100; i < arr.length; i++) {
            if (queue.peek()<arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] res = new int[100];
        for (int i = 0; i < 100; i++) {
            res[i]=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            arr[i] = r.nextInt(1000000);
        }
        int[] ints = max100(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
