package leetcode.dynamic;

/**
 * 72.�༭����
 * ������������ word1 �� word2�� �뷵�ؽ� word1 ת���� word2 ��ʹ�õ����ٲ�����
 * ����Զ�һ�����ʽ����������ֲ�����
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 */
public class Leetcode_72 {
    /**
     * ���㽫 word1 ת��Ϊ word2 �������С��������������һ��
     *
     * @param word1 ��һ���ַ���
     * @param word2 �ڶ����ַ���
     * @return ��С��������
     */
    public int minDistance(String word1, String word2) {
        // ����һ����ά���飬���ڴ洢��С��������
        // result[i][j] ��ʾ�� word1 ��ǰ i ���ַ�ת��Ϊ word2 ��ǰ j ���ַ��������С��������
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        // ��ʼ����һ�к͵�һ�У���ʾ�����ַ���ת��Ϊ word1 �� word2 ����Ĳ�������
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        // �𲽼�����С��������
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // �����ǰ�ַ���ȣ����������ȡ���Ͻǵ�ֵ
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    // �����ǰ�ַ�����ȣ�ȡ���ֲ�����ʽ����Сֵ��
                    // ���һ���滻�������� word1 �ĵ� i ���ַ��滻Ϊ word2 �ĵ� j ���ַ�����������Ϊ result[i - 1][j - 1] + 1
                    // ������������������ word2 �ĵ� j ���ַ����뵽 word1 �ĵ� i ���ַ�֮ǰ����������Ϊ result[i][j - 1] + 1
                    // �������ɾ���������� word1 �ĵ� i ���ַ�ɾ������������Ϊ result[i - 1][j] + 1
                    // ȡ�����ֲ�����ʽ����Сֵ��Ϊ��ǰλ�õ���С��������
                    result[i][j] = Math.min(result[i - 1][j - 1] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j] + 1));
                }
            }
        }
        // �������һ��λ�õ���С���������������յĽ��
        return result[result.length - 1][result[0].length - 1];
    }
}
