package leetcode.dynamic;

public class Leetcode_518 {
    public int change(int amount, int[] coins) {
        // dp[i]:�ճ��ܽ��Ϊi���������dp[i]��
        int[] result = new int[amount + 1];
        // ��ʼ��dp���� �ճ��ܽ��Ϊ0���������1��
        result[0] = 1;
        // ������� �ȱ�����Ʒ �ٱ�������
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < result.length; j++) {
                result[j] += result[j - coins[i]];
            }
        }
        return result[result.length - 1];
    }
}
