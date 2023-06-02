package leetcode.dynamic;

/**
 * 279.��ȫƽ����
 * ����һ������ n ������ ��Ϊ n ����ȫƽ�������������� ��
 * ��ȫƽ���� ��һ����������ֵ������һ��������ƽ�������仰˵
 * ��ֵ����һ�������Գ˵Ļ������磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�
 *
 * ����� 322.��Ǯ�һ� ����⼸����һģһ��
 */
public class Leetcode_279 {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        // dp[j]����Ϊj����ȫƽ��������������Ϊdp[j]
        int[] result = new int[n + 1];
        // ��ʼ��dp���飬������Ԫ�س�ʼ��Ϊһ���ϴ��ֵ��max��
        for (int i = 0; i < result.length; i++) {
            result[i] = max;
        }
        // ��������0�����������ȫƽ��������Ϊ0
        result[0] = 0;
        // ������0��n������(��Ʒ)
        for (int i = 0; i * i <= n; i++) {
            // �����������(����)
            for (int j = i * i; j < result.length; j++) {
                // ������ʹ�õ�ǰ��ȫƽ�������Եõ�����j
                if (result[j - (i * i)] != max) {
                    // ������С��ȫƽ��������
                    result[j] = Math.min(result[j], result[j - (i * i)] + 1);
                }
            }
        }
        // ��������������һ��Ԫ����Ϊmax����ʾ�޷��ճ�Ŀ������
        return result[result.length - 1] == max ? -1 : result[result.length - 1];
    }
}