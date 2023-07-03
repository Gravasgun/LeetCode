package leetcode.dynamic;

public class Leetcode_188 {
    public int maxProfit(int k, int[] prices) {
        // result[i][j] ��ʾ�ڵ�i����е�j�ν���ʱ���������
        // j=0 ��ʾδ�����κν���
        // j=1 ��ʾ������һ���������
        // j=2 ��ʾ������һ����������
        // j=3 ��ʾ�����������������
        // j=4 ��ʾ������������������
        // �Դ����ƣ�ֱ�� j=2k ��ʾ������k����������
        int[][] result = new int[prices.length][2 * k + 1];
        for (int i = 0; i < result[0].length; i++) {
            if (i % 2 == 0) {
                result[0][i] = 0;
            } else {
                result[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // �� j Ϊż��ʱ����ʾ������������(������)
                // ���ܵ���������֣�
                // 1. ǰһ���Ѿ���������ͬ��������������(������)�����첻��
                // 2. ǰһ���������ͬ��������������������������������ӹ�Ʊ�۸�
                if (j % 2 == 0) {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1] + prices[i]);
                } else {
                    // �� j Ϊ����ʱ����ʾ�����������
                    // ���ܵ���������֣�
                    // 1. ǰһ���Ѿ���������ͬ������������������첻��
                    // 2. ǰһ���������ͬ�����������������������룬�����ȥ��Ʊ�۸�
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1] - prices[i]);
                }
            }
        }
        // �������һ�����k����������ʱ���������
        // �������Ҫô�����һ�����k�����������������Ҫô�����һ�����k-1���������������
        return Math.max(result[result.length - 1][result[0].length - 2], result[result.length - 1][result[0].length - 1]);
    }
}
