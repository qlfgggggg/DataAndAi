package qiaolf.leetcode;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/10/25 22:38
 **/
public class solution392 {
    public boolean isSubsequence(String s, String t) {
        int h = 0;
        int q = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = h; j < t.length(); j++) {
                if (s.charAt(i)-t.charAt(j)==0){
                    h=j+1;
                    q++;
                    break;
                }
            }
        }
        if (q==s.length()){
            return true;
        }
        return false;
    }
}
