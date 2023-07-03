package leetcode.dynamic;

public class Leetcode_123 {
    public int maxProfit(int[] prices) {
        // result[i][j] ��ʾ�ڵ�i����е�j�ν���ʱ���������
        int[][] result = new int[prices.length][5];
        // j=0 ��ʾδ�����κν���
        // j=1 ��ʾ��һ�γ���
        // j=2 ��ʾ��һ�β�����
        // j=3 ��ʾ�ڶ��γ���
        // j=4 ��ʾ�ڶ��β�����
        result[0][0] = 0;
        result[0][1] = -prices[0];
        result[0][2] = 0;
        result[0][3] = -prices[0];
        result[0][4] = 0;
        for (int i = 1; i < result.length; i++) {
            // ������е�һ�γ���ʱ���������
            // ���ܵ���������֣�
            // 1. ǰһ���Ѿ���һ�γ��У����첻��
            // 2. ǰһ��δ�����κν��ף��������룬�����ȥ��Ʊ�۸�
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i]);
            // ������е�һ�β�����ʱ���������
            // ���ܵ���������֣�
            // 1. ǰһ���Ѿ���һ�β����У����첻��
            // 2. ǰһ���Ѿ���һ�γ��У������������������ӹ�Ʊ�۸�
            result[i][2] = Math.max(result[i - 1][2], result[i - 1][1] + prices[i]);
            // ������еڶ��γ���ʱ���������
            // ���ܵ���������֣�
            // 1. ǰһ���Ѿ��ڶ��γ��У����첻��
            // 2. ǰһ���Ѿ���һ�β����У��������룬�����ȥ��Ʊ�۸�
            result[i][3] = Math.max(result[i - 1][3], result[i - 1][2] - prices[i]);
            // ������еڶ��β�����ʱ���������
            // ���ܵ���������֣�
            // 1. ǰһ���Ѿ��ڶ��β����У����첻��
            // 2. ǰһ���Ѿ��ڶ��γ��У������������������ӹ�Ʊ�۸�
            result[i][4] = Math.max(result[i - 1][4], result[i - 1][3] + prices[i]);
        }
        // �������һ�����������������ʱ���������
        return Math.max(result[result.length - 1][3], result[result.length - 1][4]);
    }
}
