package leetcode.dynamic;

public class Leetcode_309 {
    public int maxProfit(int[] prices) {
        int[][] result = new int[prices.length][3];
        // 0:�䶳��
        result[0][0] = 0;
        // 1:����
        result[0][1] = -prices[0];
        // 2:������
        result[0][2] = 0;
        for (int i = 1; i < result.length; i++) {
            // ��i�촦���䶳��˵�� i-1�������˹�Ʊ
            result[i][0] = result[i - 1][1] + prices[i];
            // ��i����й�Ʊ ˵�� Ҫôi-1���Ѿ����иù�Ʊ Ҫô���ǵ�i�������Ʊ
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][2] - prices[i]);
            // ��i�첻���й�Ʊ ˵�� Ҫô i-1�첻���й�Ʊ
            // Ҫô��i-1�촦���䶳��(��i�첻�ܹ��� -> ��i-1�����һ�������� -> ������i-1�����״̬�Ƶ�)
            result[i][2] = Math.max(result[i - 1][0], result[i - 1][2]);
        }
        return Math.max(result[result.length - 1][0], Math.max(result[result.length - 1][1], result[result.length - 1][2]));
    }
}
