package leetcode.dynamic;

public class Leetcode_62 {
    public int uniquePaths(int m, int n) {
        // result[i][j]:��������Ϊ(i,j)��result[i][j]�ֲ�ͬ��·��
        int[][] result = new int[m][n];
        // ��ʼ����һ��
        for (int i = 0; i < result.length; i++) {
            result[i][0] = 1;
        }
        // ��ʼ����һ��
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = 1;
        }
        // ���dp���� ��Ϊdp[i][j]����dp[i][j-1]��dp[i-1][j]�Ƶ�������
        // ����Ӧ�� ��ǰ���� �������±���
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }
        // ���ص���(m,n)��·������
        return result[result.length - 1][result[0].length - 1];
    }
}
