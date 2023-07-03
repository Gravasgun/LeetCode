package leetcode.dynamic;

public class Leetcode_122 {
    public int maxProfit(int[] prices) {
        // result[i][0]:��i����й�Ʊ���������
        // result[i][1]:��i�첻���й�Ʊ���������
        int[][] result = new int[prices.length][2];
        result[0][0] = -prices[0];
        result[0][1] = 0;
        for (int i = 1; i < result.length; i++) {
            // ��i����й�Ʊ��������� = ǰһ����й�Ʊ �� ��������
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] - prices[i]);
            // ��i�첻���й�Ʊ��������� = ǰһ�첻�й�Ʊ �� ��������
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] + prices[i]);
        }
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}
