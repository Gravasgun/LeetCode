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
        // ����һ���������ڴ洢����ÿ�����ݵķ�����
        int[] result = new int[n];
        // ��ʼ��ǰ�������ݵķ�����
        result[0] = 1;
        result[1] = 2;
        // �ӵ�3�����ݿ�ʼ����
        for (int i = 2; i < result.length; i++) {
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
}