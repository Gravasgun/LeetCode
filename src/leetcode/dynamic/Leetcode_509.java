package leetcode.dynamic;

/**
 * 509.쳲�������
 * 쳲������� ��ͨ���� F(n) ��ʾ���γɵ����г�Ϊ 쳲��������� ��
 * �������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
 * F(0) = 0��F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)������ n > 1
 * ���� n ������� F(n) ��
 */
public class Leetcode_509 {
    /**
     * ����һ���ݹ�
     *
     * @param n �����쳲�������������
     * @return �� n ��쳲�������
     */
    public int fibMethodOne(int n) {
        // ����������� n ���� 0 ʱ������ 0
        if (n == 0) {
            return 0;
        }
        // ����������� n ���� 1 ʱ������ 1
        if (n == 1) {
            return 1;
        }
        // �ݹ���ã������ n ��쳲�����������ǰ�������ĺ�
        return fibMethodOne(n - 1) + fibMethodOne(n - 2);
    }

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
        // ����һ���������ڴ洢�������쳲�������
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