package leetcode.dynamic;

public class CompletedBagProblem {
    public static void main(String[] args) {
        // ��Ʒ������
        int[] weights = new int[]{1, 3, 4};
        // ��Ʒ�ļ�ֵ
        int[] values = new int[]{15, 20, 30};
        // �������������
        int bagSize = 4;
        // һά����
        testCompletedBagProblem(weights, values, bagSize);
        // ��ά����
        testCompletedBagProblem2(weights, values, bagSize);
    }

    private static void testCompletedBagProblem2(int[] weights, int[] values, int bagSize) {
        // ����dp���� dp[i][j]:����Ϊi�ı���װ[0,i]����Ʒ������ֵΪdp[i][j]
        int[][] result = new int[weights.length][bagSize + 1];
        // ��ʼ��dp����ĵ�һ��
        for (int i = weights[0]; i < result[0].length; i++) {
            result[0][i] = values[0];
        }
        // ���dp���� �ȱ�����Ʒ �ٱ�������
        for (int i = 1; i < weights.length; i++) {
            for (int j = weights[i]; j < result[0].length; j++) {
                result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - weights[i]] + values[i]);
            }
        }

        //����dp����
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void testCompletedBagProblem(int[] weights, int[] values, int bagSize) {
        // ����dp���� dp[i]:����Ϊi�ı�����װ��Ʒ������ֵΪdp[i]
        int[] result = new int[bagSize + 1];
        // �ȱ�����Ʒ �ٱ�������(�ɵߵ�)
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j < result.length; j++) {
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        System.out.println("һά����------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println("��ά����------------------------");
    }
}
