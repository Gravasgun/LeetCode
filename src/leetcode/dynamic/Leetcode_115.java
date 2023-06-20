package leetcode.dynamic;

/**
 * 115.��ͬ��������
 * ���������ַ��� s �� t ��ͳ�Ʋ������� s �� ������ �� t ���ֵĸ�����
 */
public class Leetcode_115 {
    public int numDistinct(String s, String t) {
        // ����һ����ά�������ڴ洢״̬ת�ƽ��
        // dp[i][j]����i-1Ϊ��β��s�������г�����j-1Ϊ��β��t�ĸ���Ϊdp[i][j]
        int[][] result = new int[s.length() + 1][t.length() + 1];
        // ��ʼ����һ�У���ʾ���ַ��� s ��ȡ���ַ��������Եõ�һ�����ַ�������˽��Ϊ 1
        for (int i = 0; i < result.length; i++) {
            result[i][0] = 1;
        }
        // ����״̬ת�Ƽ���
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // �����ǰ�ַ���ȣ���������ѡ��
                    // 1. ѡ��ǰ�ַ�����ʾ�����ַ�ƥ�䵽 t �ĵ�ǰλ�ã�Ȼ�����ƥ��ǰ����ַ�
                    // 2. ��ѡ��ǰ�ַ�����ʾ�����ַ�����������ƥ��ǰ����ַ�
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                } else {
                    // �����ǰ�ַ�����ȣ���ֻ�ܽ����ַ�����������ƥ��ǰ����ַ�
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        // �������һ��״̬����ʾ���ַ��� s ��ƥ�䵽�ַ��� t �ķ�����
        return result[result.length - 1][result[0].length - 1];
    }
}
