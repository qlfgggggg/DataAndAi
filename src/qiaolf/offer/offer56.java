package qiaolf.offer;

/**
 * @Description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:qiaolf
 * @Date:2021/8/3 14:35
 **/
public class offer56 {
    //异或运算:相同为0,不同为1,不进位相加
    public int[] singleNumbers(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num^nums[i];
        }
        /**
         * 最后得到的结果是两个一次的进行异或：
         * 把两个一次的分开，分进两组
         * 别的不是一次的两者分在这两组，但是相同的要分在一组
         */
        //找到num的某一位为1，如果不为1,就最后得到0
        int div = 1;
        while ((div & num)==0){
            div=div<<1;
        }
        int a=0,b=0;
        for (int i : nums) {
            if ((i & div)==0){
                a ^=i;
            }else{
                b^=i;
            }
        }
        return new int[]{a,b};
    }
}
