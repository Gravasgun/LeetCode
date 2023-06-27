package leetcode.dynamic;

public class BagProblem {
    public static void main(String[] args) {
        // ��Ʒ������
        int[] weights = new int[]{1, 3, 4};
        // ��Ʒ�ļ�ֵ
        int[] values = new int[]{15, 20, 30};
        // �������������
        int bagSize = 4;
        // ��̬�滮����
        //testBagProblem(weights, values, bagSize);
        testBagProblem2(weights, values, bagSize);
    }

    private static void testBagProblem(int[] weights, int[] values, int bagSize) {
        // result[i][j]:��������Ϊjʱ�������[0,i]����Ʒ������ֵΪresult[i][j]
        int[][] result = new int[weights.length][bagSize + 1];
        // ��ʼ����һ��
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // ���dp����
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // �����ǰ��Ʒ�����������˱������� ����ֵֻ�ܼ̳���һ����Ʒ������ֵ
                if (weights[i] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    // ��ǰ��Ʒ����С�ڵ��ڱ������� ��ʱ����ѡ�������߲����� ȡ����ֵ
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - weights[i]] + values[i]);
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

    private static void testBagProblem2(int[] weights, int[] values, int bagSize) {
        // result[j]:��������Ϊj������ֵΪresult[j]
        int[] result = new int[bagSize + 1];
        // �ȱ�����Ʒ �ٱ������� ����������ʱ�������
        for (int i = 0; i < weights.length; i++) {
            for (int j = result.length - 1; j >= weights[i]; j--) {
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        // ����dp����
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
