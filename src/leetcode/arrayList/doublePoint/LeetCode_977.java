package leetcode.arrayList.doublePoint;

import java.util.Arrays;

public class LeetCode_977 {
    /**
     * 977.���������ƽ��
     * ����һ�����ǵݼ�˳���������������nums������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
     *
     * @param nums
     * @return
     */
    public int[] sortedSquaresMethodOne(int[] nums) {
        for (int i=0;i< nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquaresMethodTwo(int[] nums) {
        //��ֵ��
        int left = 0;
        //��ָ��
        int right = nums.length - 1;
        //��������±�
        int index = right;
        int[] arr = new int[nums.length];
        while (left <= right) {
            if ((nums[left] * nums[left]) > (nums[right] * nums[right])) {
                arr[index--] = nums[left] * nums[left];
                ++left;
            } else {
                arr[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return arr;
    }
}
