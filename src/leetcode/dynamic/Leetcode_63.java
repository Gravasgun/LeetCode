package leetcode.dynamic;

public class Leetcode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dp[i][j]:����(i,j)��dp[i][j]�ֲ�ͬ·��
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        // ��ʼ����һ��
        for (int i = 0; i < result[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                result[0][i] = 1;
            } else {
                break;
            }
        }
        // ��ʼ����һ��
        for (int i = 0; i < result.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                result[i][0] = 1;
            } else {
                break;
            }
        }
        // ���dp����
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // �����ǰλ�����ϰ���
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                    // ����Ϸ����ϰ���
                } else if (obstacleGrid[i - 1][j] == 1) {
                    result[i][j] = result[i][j - 1];
                    // ��������ϰ���
                } else if (obstacleGrid[i][j - 1] == 1) {
                    result[i][j] = result[i - 1][j];
                    // ����Ϸ����󷽶����ϰ���
                } else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) {
                    result[i][j] = 0;
                    // �Ϸ����󷽶�û�ϰ���
                } else {
                    result[i][j] = result[i][j - 1] + result[i - 1][j];
                }
            }
        }
        // ���ص���(i,j)�Ĳ�ͬ·����
        return result[result.length - 1][result[0].length - 1];
    }
}
