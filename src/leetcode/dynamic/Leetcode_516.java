package leetcode.dynamic;

/**
 * 516.�����������
 *����һ���ַ��� s ���ҳ�������Ļ��������У������ظ����еĳ��ȡ�
 * �����ж���Ϊ�����ı�ʣ���ַ�˳�������£�ɾ��ĳЩ�ַ����߲�ɾ���κ��ַ��γɵ�һ�����С�
 */
public class Leetcode_516 {
    public int longestPalindromeSubseq(String s) {
        // // dp[i][j]:��ʾ���䷶Χ[i,j]������ұգ��Ļ����Ӵ�����󳤶�
        int[][] result = new int[s.length()][s.length()];
        // ��ʼ���Խ����ϵ�Ԫ�أ���ʾ�����ַ��Ļ��������г���Ϊ1
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        // �������ϣ��������ұ�������
        for (int i = result.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < result[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // ��ǰ�ַ���ȣ����Խ������ַ���������������У����ȼ�2
                    result[i][j] = result[i + 1][j - 1] + 2;
                } else {
                    // ��ǰ�ַ�����ȣ�ȡ�����²�������������г���
                    result[i][j] = Math.max(result[i][j - 1], result[i + 1][j]);
                }
            }
        }
        // ���ؾ�������Ͻ�Ԫ�أ��������ַ���������������г���
        return result[0][result[0].length - 1];
    }
}
