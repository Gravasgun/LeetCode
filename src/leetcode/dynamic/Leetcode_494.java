package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_494 {
    public int findTargetSumWays(int[] nums, int target) {
        // ���
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        if (target < 0 && -target > sum) {
            return 0;
        }
        // left(����)��right(����)��sum(�����)��target(Ŀ���)
        // left + right = sum
        // left - right = target
        // left = (sum + target) / 2
        int size = (sum + target) / 2;
        // ����dp���� dp[j]:װ������Ϊj�ı�����dp[j]�ַ�ʽ
        int[] result = new int[size + 1];
        // ��ʼ��dp����
        result[0] = 1;
        // ���dp����
        for (int i = 0; i < nums.length; i++) {
            for (int j = result.length - 1; j >= nums[i]; j--) {
                result[j] += result[j - nums[i]];
            }
        }
        return result[result.length - 1];
    }
}
