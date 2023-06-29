package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_279 {
    public int numSquares(int n) {
        // dp[i]:��Ϊi����ȫƽ��������������Ϊdp[i]
        int[] result = new int[n + 1];
        // ��Ŀ������ ���Գ�ʼ��dp����Ϊ���ֵ
        Arrays.fill(result, Integer.MAX_VALUE);
       // dp[0]:��Ϊ0����ȫƽ��������������Ϊ0
        result[0] = 0;
        // ������� �ȱ�����Ʒ �ٱ�������
        for (int i = 0; i * i <= n; i++) {
            for (int j = i * i; j < result.length; j++) {
                // ���ʹ�õ�ǰ��ȫƽ�������Եõ�����j
                if (result[j - i * i] != Integer.MAX_VALUE) {
                    result[j] = Math.min(result[j], result[j - i * i] + 1);
                }
            }
        }
        return result[result.length - 1] == Integer.MAX_VALUE ? -1 : result[result.length - 1];
    }
}
