package leetcode;

public class solution167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length<2){
            return null;
        }
        int i = 0,j=numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target){
                break;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                j--;
            }
        }

        if (numbers[i]+numbers[j]==target){
            return new int[]{i+1,j+1};
        }else{
            return null;
        }

    }
}
