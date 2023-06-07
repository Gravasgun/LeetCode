package leetcode.dynamic;

/**
 * 121.������Ʊ�����ʱ��
 * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
 * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
 * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
 */
public class Leetcode_121 {
    /**
     * ����һ��������
     * �������е����������������ϣ��������󲢸����������
     *
     * @param prices �۸�����
     * @return �������
     */
    public int maxProfitMethodOne(int[] prices) {
        int max = Integer.MIN_VALUE;
        // �������е�����������������
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // �����ǰ�����۸��ȥ����۸����0����������󲢸����������
                if (prices[j] - prices[i] > 0) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        // ������������Ȼ�ǳ�ʼֵInteger.MIN_VALUE�����ʾû��ӯ��������0�����򷵻��������
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /**
     * ��������̰�ķ�
     * ά��һ����С����۸�ͬʱ����ÿ���������ڵ����󲢸����������
     *
     * @param prices �۸�����
     * @return �������
     */
    public int maxProfitMethodTwo(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            // ������С����۸�
            min = Math.min(min, prices[i]);
            // ���㵱ǰ�������ڵ����󲢸����������
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }

    /**
     * ����������̬�滮
     * ʹ�ö�̬�滮˼�룬ά��һ����ά����result������result[i][0]��ʾ��i����й�Ʊ���������result[i][1]��ʾ��i�첻���й�Ʊ���������
     *
     * @param prices �۸�����
     * @return �������
     */
    public int maxProfitMethodThree(int[] prices) {
        int[][] result = new int[prices.length][2];
        // ��0����й�Ʊ���������Ϊ�����Ʊ�ĸ�ֵ
        result[0][0] = -prices[0];
        // ��0�첻���й�Ʊ���������Ϊ0
        result[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // ��ǰ���й�Ʊ���������Ϊǰһ����л�������Ľϴ�ֵ
            result[i][0] = Math.max(result[i - 1][0], -prices[i]);
            // ��ǰ�����й�Ʊ���������Ϊǰһ�첻���л��������Ľϴ�ֵ
            result[i][1] = Math.max(result[i - 1][1], result[i][0] + prices[i]);
        }
        // �������һ����л򲻳��й�Ʊ�Ľϴ�ֵ��Ϊ�������
        return Math.max(result[result.length - 1][0], result[result.length - 1][1]);
    }
}