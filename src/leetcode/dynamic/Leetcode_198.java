package leetcode.dynamic;

public class Leetcode_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // result[i]:[0,i]��Χ�ڵ������Ϊresult[i]
        int[] result = new int[nums.length];
        // ��ʼ��
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        // ���dp����
        for (int i = 2; i < result.length; i++) {
            // ����num[i]:result[i-2]+nums[i]
            // ������i:result[i-1]
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
        }
        return result[result.length - 1];
    }
}
