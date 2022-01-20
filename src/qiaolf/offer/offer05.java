package qiaolf.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/7/28 9:14
 **/
public class offer05 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        String t = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                t+="%20";
            }else{
                t+=chars[i];
            }
        }
        return t;
    }
}
