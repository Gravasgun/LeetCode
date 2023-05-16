package leetcode.back_track;

/**
 * 37.������
 * ��дһ������ͨ�����ո�������������⡣
 * �����Ľⷨ�� ��ѭ���¹���
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�����ο�ʾ��ͼ��
 * �������ֿո��������������֣��հ׸��� '.' ��ʾ��
 */
public class Leetcode_37 {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    /**
     * �����㷨�����������
     *
     * @param board �������
     * @return �Ƿ�ɹ��ҵ���
     */
    private boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // �����ǰ�����Ѿ������֣�������
                if (board[i][j] != '.') {
                    continue;
                }
                // ������������
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k; // ��������
                        boolean isSuccess = backTrack(board); // �ݹ�������ʣ�ಿ��
                        if (isSuccess) {
                            return true; // ����ҵ��⣬��ֱ�ӷ��سɹ�
                        }
                        board[i][j] = '.'; // ���ݣ��������������
                    }
                }
                return false; // �޷�������Ч���֣�����ʧ��
            }
        }
        return true; // �����Ѿ����������سɹ�
    }

    /**
     * �������������ڵ�ǰλ���Ƿ���Ч
     *
     * @param row   ��ǰ������
     * @param col   ��ǰ������
     * @param val   Ҫ���������
     * @param board �������
     * @return �Ƿ���Ч
     */
    private boolean isValid(int row, int col, char val, char[][] board) {
        // ��鵱ǰ���Ƿ������ͬ����
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false; // ������ͬ���֣���Ч
            }
        }

        // ��鵱ǰ���Ƿ������ͬ����
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false; // ������ͬ���֣���Ч
            }
        }

        // ��鵱ǰ 3x3 �����Ƿ������ͬ����
        int startRow = (row / 3) * 3; // �������ʼ������
        int startCol = (col / 3) * 3; // �������ʼ������
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false; // ������ͬ���֣���Ч
                }
            }
        }
        return true; // ������Ч
    }
}