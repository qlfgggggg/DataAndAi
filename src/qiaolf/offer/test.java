package qiaolf.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/7/28 19:02
 **/
class Test {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(7);
        a.add(5);
        a.add(3);
        a.add(1);
        a.add(2);
        a.add(6);
        a.add(4);
        a.add(1);
        b.add(2);
        b.add(5);
        b.add(7);
        b.add(1);
        b.add(3);
        b.add(4);
        b.add(9);
        b.add(8);
        b.add(5);
        List<Integer> union = union(a, b);
        System.out.println(union);
    }
    public static List<Integer> union(List<Integer> a,List<Integer> b){
        a.addAll(b);
        sort2(a);
        for (int i = a.size()-1; i>=0 && a.get(i)==Integer.MAX_VALUE; i--) {
                a.remove(i);
        }
        return a;
    }
    public static void sort2(List<Integer> list){
        if (list==null || list.size()<2){
            return;
        }
        int mergeSzie = 1;
        int N = list.size();
        while (mergeSzie<N){
            int L = 0;
            while (L<N){
                int R = L+mergeSzie-1;
                if (R>=N){
                    break;
                }
                int M = Math.min(N-1,R+mergeSzie);
                merge(list,L,R,M);
                L=M+1;
            }
            if (mergeSzie>N/2){
                break;
            }
            mergeSzie*=2;
        }
    }
    private static void merge(List<Integer> list, int l, int mid, int r) {
        Integer[] res = new Integer[r-l+1];
        int p = l;
        int q = mid+1;
        int i=0;
        while (p<=mid && q<=r){
            if (list.get(p)>list.get(q)){
                res[i++] = list.get(q++);
            }else {
                if (list.get(p)==list.get(q)){
                    res[i++]=list.get(p++);
                    q++;
                }else{
                    res[i++] = list.get(p++);
                }
            }
        }
        while (p<=mid){
            res[i++] = list.get(p++);
        }
        while (q<=r){
            res[i++] = list.get(q++);
        }
        if (i< res.length){
            for (int j = i; j < res.length; j++) {
                res[j]=Integer.MAX_VALUE;
//                res[j]=null;
            }
        }
        for (int j = 0; j < res.length; j++) {
            list.set(l+j,res[j]);
        }
    }
}
