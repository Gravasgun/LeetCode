package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]:�ճ�i��������Ӳ�Ҹ���Ϊdp[i]
        int[] result = new int[amount + 1];
        // ��Ŀ����Сֵ ����Ҫ��dp�������Ϊ���ֵ
        Arrays.fill(result, Integer.MAX_VALUE);
        // �ճ�"0"��������Ӳ�Ҹ���Ϊ0 ���ﲻ�������ֵ ��Ȼû�취����
        result[0] = 0;
        // ������� �ȱ�����Ʒ �ٱ�������
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < result.length; j++) {
                // ���ʹ�õ�ǰӲ�ҿ��Եõ����j
                if (result[j - coins[i]] != Integer.MAX_VALUE) {
                    result[j] = Math.min(result[j], result[j - coins[i]] + 1);
                }
            }
        }
        return result[result.length - 1] == Integer.MAX_VALUE ? -1 : result[result.length - 1];
    }
}
