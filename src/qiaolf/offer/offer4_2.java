package qiaolf.offer;


import java.math.BigInteger;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/9/27 21:14
 **/
public class offer4_2 {
    public static int cuttingRope(int n) {
        if(n==2)
            return 1;
        if (n==3)
            return 2;
        if (n==4)
            return 4;
        BigInteger result = BigInteger.ONE;
        while (n>4){
            n-=3;
            result = result.multiply(BigInteger.valueOf(3));
        }
        result = result.multiply(BigInteger.valueOf(n));
//        return result.divideAndRemainder(BigInteger.valueOf(1000000007))[1].intValue();
        return result.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope2(10));
    }

    public static int cuttingRope2(int n) {
        BigInteger dp[] = new BigInteger[n+1];
        dp[2] = BigInteger.valueOf(1);
        if (n>=3){
            dp[3]= BigInteger.valueOf(2);
        }
        if (n>=4){
            dp[4]= BigInteger.valueOf(4);
        }
        if (n>=5){
            dp[5]=BigInteger.valueOf(6);
        }
        if (n>=6){
            dp[6]=BigInteger.valueOf(9);
        }
        for (int i = 7; i <=n; i++) {
            dp[i]=dp[i-3].multiply(BigInteger.valueOf(3));
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }


}
