package leetcode.dynamic;

/**
 * 70.��¥��
 * ������������¥�ݡ���Ҫ n �ײ��ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * ע�⣺������ n ��һ����������
 */
public class Leetcode_70 {
    /**
     * ����һ����̬�滮
     *
     * @param n ¥�ݵĽ���
     * @return ����¥���Ĳ�ͬ������
     */
    public int climbStairsMethodOne(int n) {
        if (n <= 2) {
            return n;
        }
        // ����һ��dp�������ڴ洢����ÿ�����ݵķ�����
        // dp[i]��������i��¥�ݣ���dp[i]�ַ���
        int[] result = new int[n+1];
        // ��ʼ��ǰ�������ݵķ�����
        result[1] = 1;
        result[2] = 2;
        // �ӵ�3�����ݿ�ʼ����
        for (int i = 3; i < result.length; i++) {
            // �����i�����ݵķ��������ڵ����i-1�����ݵķ��������ϵ����i-2�����ݵķ�����
            result[i] = result[i - 1] + result[i - 2];
        }
        // ���ص���¥���ķ��������������n�����ݵķ�����
        return result[result.length - 1];
    }

    /**
     * ���������ݹ�
     *
     * @param n ¥�ݵĽ���
     * @return ����¥���Ĳ�ͬ������
     */
    public int climbStairsMethodTwo(int n) {
        if (n <= 2) {
            return n;
        }
        // �ݹ���ã������n�����ݵķ��������ڵ����n-1�����ݵķ��������ϵ����n-2�����ݵķ�����
        return climbStairsMethodTwo(n - 1) + climbStairsMethodTwo(n - 2);
    }

    /**
     * ��¥�ݽ��װ�
     * ��Ϊһ�ο�����[1,stairs]������
     * ��ʱ����һ����ȫ�������� �������Ľ�����������Ʒ ¥�����Ǳ�������
     * @param n ¥�ݵĽ���
     * @return ����¥���Ĳ�ͬ������
     */
    public int climbStairsMethodThree(int n) {
        // ����һ������Ϊn + 1��dp���飬dp[i]��������i��̨�׵�¥������dp[i]�ַ���
        int[] result = new int[n + 1];
        // ���̨����
        int stairs = 2;
        // ��result[0]��ʼ��Ϊ1����ʾ����̨����Ϊ0�ķ�ʽ����Ϊ1
        result[0] = 1;
        // ���ѭ������result����(����)
        for (int i = 1; i < result.length; i++) {
            // �ڲ�ѭ������1��stairs֮���̨����(��Ʒ)
            for (int j = 1; j <= stairs; j++) {
                // �жϵ�ǰ̨����i�Ƿ���ڵ���j(�������������������Ʒ������)
                if (i >= j) {
                    // ��װ�������м��ַ��������ƹ�ʽһ�㶼��dp[i] += dp[i - nums[j]];
                    // �����أ�dp[i]�м�����Դ��dp[i - 1]��dp[i - 2]��dp[i - 3] �ȵȣ�����dp[i - j]
                    // ��ô���ƹ�ʽΪ��dp[i] += dp[i - j]
                    // ���米��������7�����ڵ���Ʒ��������3����ôֻ��Ҫ��עdp[4]Ϊ���ټ���
                    result[i] += result[i - j];
                }
            }
        }
        // ����result��������һ��Ԫ�� ��ʾ����¥�ݶ����Ĳ�ͬ��ʽ������
        return result[result.length - 1];
    }
}