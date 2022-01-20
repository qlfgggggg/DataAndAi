package qiaolf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/10/25 21:34
 **/
public class solution125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (isZiMu(chars[i]) || isNum(chars[i])){
                list.add(chars[i]);
            }
        }
        int l = list.size();
        if (l==0){
            return true;
        }
//        int t,r;
//        if (l%2==0){
//            t= (l-1)/2;
//            r=t+1;
//        }else{
//            t=r=(l-1)/2;
//        }
        int left = 0;
        int right = l-1;
        while (left<right){
            if (!isEqual(list.get(left),list.get(right))){
                return false;
            }
            left++;
            right--;
        }
//        while (t>=0 && r<=list.size()-1){
//            if (!isEqual(list.get(t),list.get(r))){
//                return false;
//            }
//            t--;
//            r++;
//        }
        return true;
    }

    /**
     * 该字符是字母或者数字
     * @param c
     * @return
     */
    public boolean isZiMu(char c){
        return (c-'A'>=0 && c - 'Z' <=0) || (c-'a'>=0 && c - 'z' <=0) ;
    }

    public boolean isNum(char c){
        return c-'0'>=0 && c - '9'<=0;
    }

    public boolean isEqual(char a,char b){
        if (isNum(a) && isNum(b))
            return a-b==0;
        if (isZiMu(a) && isZiMu(b))
        return a-b==0 || a-b==32 || a-b==-32;
        return false;
    }
}
