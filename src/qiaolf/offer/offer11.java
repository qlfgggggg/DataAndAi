package qiaolf.offer;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/7/28 9:27
 **/
public class offer11 {
    public int minArray(int[] numbers) {
        if (numbers.length==1){
            return numbers[0];
        }
//        if (numbers.length==2){
//            return Math.min(numbers[0],numbers[1]);
//        }
        int N = numbers.length;
        for (int i = N-1; i >=1 ; i--) {
            if (numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
