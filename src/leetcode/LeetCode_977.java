package leetcode;

import java.util.Arrays;

public class LeetCode_977 {
    /**
     * 977.���������ƽ��
     * ����һ�����ǵݼ�˳���������������nums������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        for (int i=0;i< nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
