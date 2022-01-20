package qiaolf.zuoshen.class22;

/**
 * @Description:
 * 给定3个参数，N，M，K
 * 怪兽有N滴血，等着英雄来砍自己
 * 英雄每一次打击，都会让怪兽流失[0~M]的血量
 * 到底流失多少？每一次在[0~M]上等概率的获得一个值
 * 求K次打击之后，英雄把怪兽砍死的概率
 * Author:qiaolf
 * @Date:2021/7/28 15:33
 **/
public class code1_hero {
    public static double kill(int N,int M,int K){
        if (N<1 || M< 1 || K<1){
            return 0;
        }
        double pow = Math.pow(M + 1, K);
        double process = f(N,M,K);
        return process/pow;
    }

    private static double f(int hp, int M, int time) {
        if (time==0){
            return hp<=0 ? 1 : 0;
        }
        if (hp<=0){
            return Math.pow(M+1,time);
        }
        int ways = 0;
        for (int i = 0; i <= M; i++) {
            ways += f(hp-i,M,time-1);
        }
        return ways;
    }

    public static double killDp(int N,int M,int K){
        if (N<1 || M< 1 || K<1){
            return 0;
        }
        double pow = Math.pow(M + 1, K);
        int[][] dp = new int[N+1][K+1];
        dp[0][0]=1;
        for (int i = 0; i <=K ; i++) {
            dp[0][i]=(int) Math.pow(M+1,i);
        }
        for (int j = 1; j <=K; j++) {
            for (int l = 1; l <=N; l++) {
                //把枚举放置在每个坐标dp[][]内部，这一个坐标对应所有的枚举型为
                int ways  = 0;
                for (int i = 0; i <= M; i++) {
                    ways+=(l-i)< 0 ? dp[0][j-1] : dp[l-i][j-1];
                }
                dp[l][j]=ways;
            }
        }
        return (int)dp[N][K]/pow;
    }

}
