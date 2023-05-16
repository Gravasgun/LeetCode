package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51.N�ʺ�
 * ���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�
 * n �ʺ����� �о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������ n ���������в�ͬ�� n �ʺ����� �Ľ��������
 * ÿһ�ֽⷨ����һ����ͬ�� n �ʺ����� �����ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 */
public class Leetcode_51 {
    List<List<String>> result = new ArrayList<>();

    /**
     * ���n�ʺ�����ķ���
     *
     * @param n �ʺ����������̴�С
     * @return ���в�ͬ��n�ʺ�����Ľ������
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (char[] c : chess) {
            Arrays.fill(c, '.');
        }
        backTrack(chess, 0);
        return result;
    }

    /**
     * ���ݷ����������������Ϸ��ûʺ�
     *
     * @param chess ����
     * @param row   ��ǰ������
     */
    private void backTrack(char[][] chess, int row) {
        // ����Ѿ������������У�����ǰ������ӵ�����в�����
        if (row == chess.length) {
            result.add(transform(chess));
            return;
        }
        // �ڵ�ǰ�г��Է��ûʺ�
        for (int col = 0; col < chess.length; col++) {
            // �����ǰλ�ÿ��԰�ȫ���ûʺ�
            if (isValid(chess, col, row)) {
                // ���ûʺ�
                chess[row][col] = 'Q';
                // ������һ�еĻ���
                backTrack(chess, row + 1);
                // �ָ���ǰλ��Ϊ��λ
                chess[row][col] = '.';
            }
        }
    }

    /**
     * ��鵱ǰλ���Ƿ���԰�ȫ���ûʺ�
     *
     * @param chess ����
     * @param col   ��ǰ������
     * @param row   ��ǰ������
     * @return ��ǰλ���Ƿ���԰�ȫ���ûʺ�
     */
    private boolean isValid(char[][] chess, int col, int row) {
        // ���ͬһ���Ƿ��лʺ�
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // ������Ϸ�б���Ƿ��лʺ�
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // ������Ϸ�б���Ƿ��лʺ�
        for (int i = row - 1, j = col + 1; j < chess.length && i >= 0; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * ������ת��Ϊ��������ĸ�ʽ
     *
     * @param chess ����
     * @return ��������ĸ�ʽ
     */
    private List<String> transform(char[][] chess) {
        List<String> list = new ArrayList<>();
        for (char[] c : chess) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}