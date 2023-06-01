package leetcode.dynamic;

/**
 * ��ȫ��������
 * ����һ����Ʒ��ÿ����Ʒ�ж�Ӧ�������ͼ�ֵ���Լ�һ�����������������
 * Ŀ����ѡ����Ʒ���뱳����ʹ�÷��뱳������Ʒ���ܼ�ֵ��󻯣�ͬʱ���Ǳ�������������
 * ��Ʒ�������޴α�ʹ��
 */
public class CompleteBagProblem {
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
        // ����һ������Ϊ��������+1��dp���飬���ڼ�¼ÿ�����������µ�����ֵ
        int[] result = new int[bagSize + 1];
        //�����ȱ�����Ʒ Ҳ�����ȱ������� ˳���˲�Ӱ�� ֻ��Ӱ��forѭ���е�����
        // ����ÿ����Ʒ
        for (int i = 0; i < weights.length; i++) {
            // ����Ʒ��������ʼ������ֱ����������
            for (int j = weights[i]; j < result.length; j++) {
                // ���㵱ǰ���������µ�����ֵ���Ƚ������������ѡ��ǰ��Ʒ��ѡ��ǰ��Ʒ
                // �����ѡ��ǰ��Ʒ��������ֵ����һ�μ���Ľ����ͬ
                // ���ѡ��ǰ��Ʒ��������ֵΪ��һ�μ���Ľ�����ϵ�ǰ��Ʒ�ļ�ֵ
                result[j] = Math.max(result[j], result[j - weights[i]] + values[i]);
            }
        }
        // ��ӡ��������е�ÿ��Ԫ�أ���ÿ�����������µ�����ֵ
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}