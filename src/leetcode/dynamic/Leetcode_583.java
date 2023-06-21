package leetcode.dynamic;

/**
 * 583.�����ַ�����ɾ������
 * ������������ word1 �� word2 ������ʹ�� word1 ��  word2 ��ͬ�������С������
 * ÿ�� ����ɾ������һ���ַ����е�һ���ַ���
 */
public class Leetcode_583 {
    /**
     * ���������ַ���֮�����Сɾ������������ʹ�������ַ�����ȣ�����һ��
     *
     * @param word1 ��һ���ַ���
     * @param word2 �ڶ����ַ���
     * @return ��Сɾ����������
     */
    public int minDistanceMethodOne(String word1, String word2) {
        // dp[i][j]����i-1Ϊ��β���ַ���word1������j-1λ��β���ַ���word2����Ҫ�ﵽ��ȣ�����Ҫɾ��Ԫ�ص����ٴ���
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        // ��ʼ����һ�к͵�һ�У���ʾ�����ַ���ת��Ϊword1��word2����Ĳ�������
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        // �𲽼�����С�༭����
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // ��ǰ�ַ���ȣ����������ȡ���Ͻǵ�ֵ
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    // ��ǰ�ַ�����ȣ�ȡ���ֲ�����ʽ����Сֵ��
                    // ���һ��ɾword1[i - 1]�����ٲ�������Ϊdp[i - 1][j] + 1
                    // �������ɾword2[j - 1]�����ٲ�������Ϊdp[i][j - 1] + 1
                    // ͬʱɾword1[i - 1]��word2[j - 1]�����������ٴ���Ϊdp[i - 1][j - 1] + 2
                    result[i][j] = Math.min(result[i - 1][j] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j - 1] + 2));
                }
            }
        }
        // ������Сɾ�����������������Ľ��
        return result[result.length - 1][result[0].length - 1];
    }

    /**
     * ���������ַ���֮�����Сɾ������������ʹ�������ַ������
     * ��������������еĳ���
     * ���շ���word1��word2��length֮�ͼ�ȥ2����������еĳ���
     * ������Ŀ����������ٵ�ɾ������
     *
     * @param word1 ��һ���ַ���
     * @param word2 �ڶ����ַ���
     * @return ��Сɾ����������
     */
    public int minDistanceMethodTwo(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // ��ǰ�ַ���ȣ�˵������Ҫɾ�������Լ̳�ǰ��Ĺ��������г���
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // ��ǰ�ַ�����ȣ���Ҫ����ɾ���ĸ��ַ�����ʹ�ù��������г������
                    result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                }
            }
        }
        // ��Сɾ���������� = word1���� + word2���� - 2 * ����������г���
        return word1.length() + word2.length() - 2 * result[result.length - 1][result[0].length - 1];
    }
}
