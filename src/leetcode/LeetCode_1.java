package leetcode;

public class LeetCode_1 {
    /**
     * 1.����֮��
     * ����һ����������nums��һ������Ŀ��ֵtarget�������ڸ��������ҳ���ΪĿ��ֵtarget�����������������������ǵ������±ꡣ
     * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
     * ����԰�����˳�򷵻ش𰸡�
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
