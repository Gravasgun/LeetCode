package leetcode.dynamic;

/**
 * 01��������
 * ����һ����Ʒ��ÿ����Ʒ���Լ��������ͼ�ֵ������һ������ΪbagSize�ı�����
 * ��Ҫ�ڲ���������������ǰ���£�ѡ��һЩ��Ʒ���뱳���У�ʹ�÷������Ʒ�ܼ�ֵ��󻯡�
 * ����������
 * ÿ����ƷҪô��ȫ���뱳����Ҫô�����롣
 * ÿ����Ʒֻ��һ���������á�
 * ����ֻ��װ��һ����������Ʒ������������������Ʒ�޷����롣
 */
public class BagProblem {
    public static void main(String[] args) {
        // ��Ʒ������
        int[] weights = new int[]{1, 3, 4};
        // ��Ʒ�ļ�ֵ
        int[] values = new int[]{15, 20, 30};
        // �������������
        int bagSize = 4;
        // ��̬�滮����
        testBagProblem(weights, values, bagSize);
    }

    private static void testBagProblem(int[] weights, int[] values, int bagSize) {
        // ����dp���� dp[i][j] ��ʾ���±�Ϊ[0-i]����Ʒ������ȡ���Ž�����Ϊj�ı�������ֵ�ܺ�����Ƕ���

        int[][] result = new int[weights.length][bagSize + 1];
        // ��ʼ����һ�У���ʾֻ���ǵ�һ����Ʒʱ������������1��bagSize������µ�����ֵ
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // ��̬�滮 ���dp���� ���㱳��������1��bagSize�����ǲ�ͬ��Ʒ������µ�����ֵ
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // ��ǰ��Ʒ���������ڱ����������޷����뱳�����̳���һ�е�����ֵ
                if (weights[i] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    // ��ǰ��Ʒ������С�ڵ��ڱ�������������ѡ�����򲻷��뱳����ȡ��������µ�����ֵ
                    result[i][j] = Math.max(result[i - 1][j], (result[i - 1][j - weights[i]] + values[i]));
                }
            }
        }
        // ��ӡ�������
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
