package leetcode.dynamic;

public class Leetcode_377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]:�ܺ�Ϊi��Ԫ����ϸ���Ϊdp[i]
        int[] result = new int[target + 1];
        // dp[i]:�ܺ�Ϊi��Ԫ����ϸ���Ϊdp[i] ��ʲô����ѡ
        result[0] = 1;
        //�����и��� �ȱ������� �ٱ�����Ʒ
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // ��������������ڵ�����Ʒ����
                if (nums[j] <= i) {
                    result[i] += result[i - nums[j]];
                }
            }
        }
        return result[result.length - 1];
    }
}
