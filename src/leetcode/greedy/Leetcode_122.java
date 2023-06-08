package leetcode.greedy;

import java.util.Arrays;

/**
 * 122.������Ʊ�����ʱ��II
 * ����һ���������� prices ������ prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
 * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�� ��� ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
 * ���� ���ܻ�õ� ��� ���� ��
 */
public class Leetcode_122 {
    /**
     * ����һ��̰��
     * �����0�����룬��3����������ô����Ϊ��prices[3] - prices[0]
     * �൱��(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
     * �ռ�����������䣬���ǹ�Ʊ���������䣬������ֻ��Ҫ��ע�������󣬲���Ҫ��¼����
     * �ֲ����ţ��ռ�ÿ���������
     * ȫ�����ţ�����������
     *
     * @param prices
     * @return
     */
    public int maxProfitMethodOne(int[] prices) {
        // ����һ���������洢�۸��ֵ������
        int[] profit = new int[prices.length - 1];
        // ��¼profit���������
        int index = 0;
        // �����۸�����
        for (int i = 1; i < prices.length; i++) {
            // ���㵱ǰ�۸���ǰһ���۸�֮��Ĳ�ֵ������
            int diff = prices[i] - prices[i - 1];
            // �����ֵ����0����ʾ���Ի������
            if (diff > 0) {
                // ������洢��profit������
                profit[index++] = diff;
            }
        }
        // ʹ�����ķ�ʽ����profit����������Ԫ�صĺͣ����������
        return Arrays.stream(profit).sum();
    }

    /**
     * ����������̬�滮
     *
     * @param prices
     * @return
     */
    public int maxProfitMethodTwo(int[] prices) {
        // ����һ����ά�������洢���
        // result[i][0] ��ʾ�ڵ�i����й�Ʊʱ���������
        // result[i][1] ��ʾ�ڵ�i�첻���й�Ʊʱ���������
        int[][] result = new int[prices.length][2];
        // ��ʼ����һ������
        result[0][0] = -prices[0];  // �ڵ�һ�������Ʊ����������Ϊ���Ĺ�Ʊ�۸�
        result[0][1] = 0;           // �ڵ�һ�첻�����Ʊ����������Ϊ0
        // ����ÿһ��ļ۸�
        for (int i = 1; i < result.length; i++) {
            // �����i����й�Ʊʱ���������
            // ���ܵ���������֣�
            // 1. ǰһ����й�Ʊ�����첻���������ֲ���
            // 2. ǰһ�첻���й�Ʊ���������룬�����ȥ��Ʊ�۸�
            result[i][0] = Math.max(result[i - 1][1] - prices[i], result[i - 1][0]);
            // �����i�첻���й�Ʊʱ���������
            // ���ܵ���������֣�
            // 1. ǰһ�첻���й�Ʊ�����챣�ֲ���
            // 2. ǰһ����й�Ʊ�������������������ӹ�Ʊ�۸�
            result[i][1] = Math.max(result[i - 1][1], result[i][0] + prices[i]);
        }
        // �������һ����������
        // �������Ҫô�����һ�첻���й�Ʊ�������Ҫô�����һ����й�Ʊ�����
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}
