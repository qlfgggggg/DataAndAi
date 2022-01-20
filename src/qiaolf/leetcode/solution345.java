package qiaolf.leetcode;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/10/24 21:09
 **/
public class solution345 {
    public String reverseVowels(String s) {
        //双指针，一个在左，一个在右
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<=j){
            if (!isYuan(chars,i)){
                i++;
            }
            if (!isYuan(chars,j)){
                j--;
            }
            if (isYuan(chars,i) && isYuan(chars,j)){
                swap(chars,i,j);
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    public boolean isYuan(char[] chars,int i){
        return chars[i]-'a'==0 || chars[i]-'e'==0 || chars[i]-'i'==0 || chars[i]-'o'==0 || chars[i]-'u'==0 || chars[i]-'A'==0 || chars[i]-'E'==0 || chars[i]-'I'==0 || chars[i]-'O'==0 || chars[i]-'U'==0;
    }
}
