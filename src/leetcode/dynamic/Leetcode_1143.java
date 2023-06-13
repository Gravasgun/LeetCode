package leetcode.dynamic;

/**
 * 1143.�����������
 * ���������ַ��� text1 �� text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
 * һ���ַ����� ������ ��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
 * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
 */
public class Leetcode_1143 {
    /**
     * �����������
     *
     * @param text1 ��һ���ַ���
     * @param text2 �ڶ����ַ���
     * @return ����������еĳ���
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // ������ά����result�����ڼ�¼����������еĳ���
        int[][] result = new int[text1.length() + 1][text2.length() + 1];
        // ����text1��text2��ÿ���ַ������result����
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // ��ǰ�ַ���ȣ����Թ��ɹ���������
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // ��ǰһ��״̬�Ļ����ϼ�1����ʾ��ǰ�ַ����������������������
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // ��ǰ�ַ�����ȣ��޷����ɹ���������
                    // ѡ��ǰһ��״̬�е�����ѡ���еĽϴ�ֵ
                    // 1. ȥ��text1�ĵ�ǰ�ַ�������text2����
                    // 2. ȥ��text2�ĵ�ǰ�ַ�������text1����
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        // �������ս������result�������½ǵ�ֵ����ʾ����������еĳ���
        return result[result.length - 1][result[0].length - 1];
    }
}