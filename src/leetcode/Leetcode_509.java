package leetcode;

public class Leetcode_509 {
    /**
     * ����������̬�滮
     *
     * @param n �����쳲�������������
     * @return �� n ��쳲�������
     */
    public int fibMethodTwo(int n) {
        if (n <= 1) {
            return n;
        }
        // ����һ��dp�������ڴ洢�������쳲�������
        // dp[i]����i������쳲�������ֵ��dp[i]
        int[] result = new int[n + 1];
        // ��ʼ��ǰ����쳲�������
        result[0] = 0;
        result[1] = 1;
        // �ӵ�2��쳲���������ʼ����
        for (int i = 2; i < result.length; i++) {
            // ����� i ��쳲�����������ǰ�������ĺ�
            result[i] = result[i - 1] + result[i - 2];
        }
        // ���ص� n ��쳲�������
        return result[result.length - 1];
    }
}
