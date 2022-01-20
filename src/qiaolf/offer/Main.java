package qiaolf.offer;
import java.util.Scanner;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/8/11 22:03
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String s = String.valueOf(num);
        System.out.println(s);
        String s1="";
        for (int i = s.length()-1; i >=0 ; i--) {
            s1 = s1+s.charAt(i);
        }
        System.out.println(s1);

    }


}
