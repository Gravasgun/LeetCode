package leetcode.dynamic;

public class Leetcode_70 {
    public int climbStairsMethodOne(int n) {
        if (n <= 2) {
            return n;
        }
        // result[i]:������i��̨����result[i]�ַ���
        int[] result = new int[n + 1];
        // ��ʼ��dp����
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        // ���dp���� result[0] result[1] result[2] ���Ѿ�����ʼ��
        // ���Դ����� ��result[3]��ʼ���
        for (int i = 3; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        // ����������n��̨�׵ķ���������
        return result[result.length - 1];
    }

    public int climbStairsMethodTwo(int n) {
        // ÿ�ο����������̨���� weight��ֵ����������и��� ��¥�ݽ��װ�
        int weight = 2;
        // ������i��̨����dp[i]�ַ���
        int[] result = new int[n + 1];
        // ������0��̨����0�ַ���
        result[0] = 1;
        // ������1��̨����1�ַ���
        result[1] = 1;
        // �������� �ȱ������� �ٱ�����Ʒ
        for (int i = 2; i < result.length; i++) {
            for (int j = 1; j <= weight; j++) {
                // �����������ڵ�����Ʒ������������� �ſ��Է�����Ʒ
                if (i >= j) {
                    result[i] += result[i - j];
                }
            }
        }
        return result[result.length - 1];
    }
}
