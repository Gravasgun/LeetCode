package leetcode.dynamic;

/**
 * 746.ʹ����С������¥��
 * ����һ���������� cost ������ cost[i] �Ǵ�¥�ݵ� i ��̨����������Ҫ֧���ķ��á�һ����֧���˷��ã�����ѡ��������һ����������̨�ס�
 * �����ѡ����±�Ϊ 0 ���±�Ϊ 1 ��̨�׿�ʼ��¥�ݡ�
 * ������㲢���شﵽ¥�ݶ�������ͻ��ѡ�
 */
public class Leetcode_746 {
    public int minCostClimbingStairs(int[] cost) {
        // ����һ��������飬����Ϊ cost.length + 1�����ڴ洢����ÿ�����ݵ���С����
        // i��ʾ��i��̨�� result[i]��ʾ�����i��̨�����ٵĻ���
        // ¥�ݵĶ�����cost.length+1 ����dp����ĳ��Ⱦ�Ӧ����cost.length+1
        int[] result = new int[cost.length + 1];
        // ��ʼ����������ǰ����Ԫ��Ϊ0����Ϊ������ʼλ�ò�����
        result[0] = 0;
        result[1] = 0;
        // �����ӵ��������ݿ�ʼ����ÿ�����ݵ���С����
        for (int i = 2; i < result.length; i++) {
            // ��ǰ���ݵ���С���ѵ��� ǰһ������������ǰ���ݵĻ��� �� ǰ��������������ǰ���ݵĻ��� �еĽ�Сֵ
            result[i] = Math.min(cost[i - 1] + result[i - 1], cost[i - 2] + result[i - 2]);
        }
        // ���ؽ�����������һ��Ԫ�أ������ﶥ������С����
        return result[result.length - 1];
    }
}
