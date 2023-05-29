package leetcode.dynamic;

/**
 * 63.��ͬ·��II
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish������
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 */
public class Leetcode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // ����dp����
        // dp[i][j] ����ʾ�ӣ�0 ��0����������(i, j) ��dp[i][j]����ͬ��·��
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        int colIndex = 0;
        // �����һ��
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            // ��һ�����ϰ����¼�±�
            if (obstacleGrid[0][i] == 1) {
                colIndex = i;
                break;
            } else {
                // ��һ��û���ϰ������·������Ϊ1
                result[0][i] = 1;
            }
        }
        // �����һ�д����ϰ����֮��ĸ��Ӷ��޷��������·��������Ϊ0
        if (colIndex != 0) {
            for (int i = colIndex; i < obstacleGrid[0].length; i++) {
                result[0][i] = 0;
            }
        }
        int rowIndex = 0;
        // �����һ��
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                // ��һ�����ϰ����¼�±�
                rowIndex = i;
                break;
            } else {
                // ��һ��û���ϰ������·������Ϊ1
                result[i][0] = 1;
            }
        }
        // �����һ�д����ϰ����֮��ĸ��Ӷ��޷��������·��������Ϊ0
        if (rowIndex != 0) {
            for (int i = rowIndex; i < obstacleGrid.length; i++) {
                result[i][0] = 0;
            }
        }
        // ��̬�滮����������ӵ�·������
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                // �����ǰ�������ϰ����·������Ϊ0
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else if (obstacleGrid[i][j - 1] == 1) {
                    // ������������ϰ����ֻ�ܴ��Ϸ����ӵ���
                    result[i][j] = result[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == 1) {
                    // ����Ϸ��������ϰ����ֻ�ܴ������ӵ���
                    result[i][j] = result[i][j - 1];
                } else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) {
                    // ��������Ϸ����Ӷ����ϰ�����޷����ﵱǰ����
                    result[i][j] = 0;
                } else {
                    // �󷽺��Ϸ���û���ϰ�������
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        // �������½Ǹ��ӵ�·��������Ϊ���
        return result[result.length - 1][result[0].length - 1];
    }
}