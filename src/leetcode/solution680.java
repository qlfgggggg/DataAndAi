package leetcode;

public class solution680 {
    public static boolean validPalindrome(String s) {
        if (s.length()<=2){
            return true;
        }
        int i = 0,j=s.length()-1;
        char[] chars = s.toCharArray();
        return solution(chars,i,j,0);
    }

    private static boolean solution(char[] chars, int i, int j,int total) {
        if (total>1){
            return false;
        }
        if (i>=j){
            return true;
        }
        if (chars[i]==chars[j]){
            return solution(chars,++i,--j,total);
        }else if (chars[i+1]!=chars[j] && chars[i]!=chars[j-1]){
            return false;
        }else if (chars[i+1]==chars[j] && chars[i]!=chars[j-1]){
            i+=2;
            j-=1;
            return solution(chars,i,j,++total);
        }else if (chars[i+1]!=chars[j] && chars[i]==chars[j-1]){
            j-=2;
            i+=1;
            return solution(chars,i,j,++total);
        }else{
            int i1 = i+2,j1 = j-1,t1 = total+1;
            int i2 = i+1,j2 = j-2,t2 = total+1;
            return solution(chars,i1,j1,t1) || solution(chars,i2,j2,t2);
            //return solution(chars,++i,j,++total) || solution(chars,i,--j,++total);
        }
    }
}
