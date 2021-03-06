package qiaolf.offer;

/**
 * @Description: 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:qiaolf
 * @Date:2021/7/13 15:31
 **/
public class offer46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        return dfs(numStr,0);
    }

    private int dfs(String numStr, int index) {
        if (index>=numStr.length()-1)
            return 1;
        int res = dfs(numStr, index+1);
        String substring = numStr.substring(index, index + 2);
        if (substring.compareTo("10")>=0 && substring.compareTo("25")<=0)
            res+=dfs(numStr,index+2);
        return res;
    }
}
