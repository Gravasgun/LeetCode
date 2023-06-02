package leetcode.dynamic;

/**
 * 322.��Ǯ�һ�
 * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
 * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ����� -1 ��
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 *
 * ������װ��������������Ʒ�ĸ���
 */
public class Leetcode_322 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        // dp[j]�������ܶ�Ϊj����Ǯ�ҵ����ٸ���Ϊdp[j]
        int[] result = new int[amount + 1];
        // ��ʼ��dp���飬������Ԫ�س�ʼ��Ϊһ���ϴ��ֵ��max��
        for (int i = 0; i < result.length; i++) {
            result[i] = max;
        }
        // ���ý��Ϊ0ʱ��Ҫ������Ӳ������Ϊ0
        result[0] = 0;
        // ����Ӳ������(��Ʒ)
        for (int i = 0; i < coins.length; i++) {
            // �����������(����)
            for (int j = coins[i]; j < result.length; j++) {
                // ������ʹ�õ�ǰӲ�ҿ��Եõ����j
                if (result[j - coins[i]] != max) {
                    // ������СӲ������
                    result[j] = Math.min(result[j], result[j - coins[i]] + 1);
                }
            }
        }
        // ��������������һ��Ԫ����Ϊmax����ʾ�޷��ճ�Ŀ����
        return result[result.length - 1] == max ? -1 : result[result.length - 1];
    }
}