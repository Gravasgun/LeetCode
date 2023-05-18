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
     * �����0�����룬��3����������ô����Ϊ��prices[3] - prices[0]
     * �൱��(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
     * �ռ�����������䣬���ǹ�Ʊ���������䣬������ֻ��Ҫ��ע�������󣬲���Ҫ��¼����
     * �ֲ����ţ��ռ�ÿ���������
     * ȫ�����ţ�����������
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
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
}
