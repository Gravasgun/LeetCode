package leetcode.arrayList.doublePoint;

public class LeetCode_283 {
    /**
     * 283.�ƶ���
     * ����һ������nums����дһ������������0�ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left=0;
        for (int right=0;right< nums.length;right++){
            if (nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
        }
        //ʣ�µ�ȫ��0
        for (;left< nums.length;left++){
            nums[left]=0;
        }
    }
}
