package leetcode.dynamic;

/**
 * 392.�ж�������
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ�����
 * �����磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 */
public class Leetcode_392 {
    /**
     * �ж��ַ��� s �Ƿ����ַ��� t ��������
     *
     * @param s �ַ��� s
     * @param t �ַ��� t
     * @return ��� s �� t �������У��򷵻� true�����򷵻� false
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        // ����һ����ά�������ڴ洢״̬ת�ƽ��
        int[][] result = new int[s.length() + 1][t.length() + 1];
        // ����״̬ת�Ƽ���
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // �����ǰ�ַ���ȣ�����֮ǰ��״̬�����ϼ�һ
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // �����ǰ�ַ�����ȣ���̳�֮ǰ��״̬
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        // �ж����һ��״̬�Ƿ���� s �ĳ���
        return result[result.length - 1][result[0].length - 1] == s.length();
    }
}
