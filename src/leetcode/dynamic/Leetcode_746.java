package leetcode.dynamic;

public class Leetcode_746 {
    public int minCostClimbingStairs(int[] cost) {
        // result[i]:�����i��̨���������ͻ���Ϊresult[i]
        int[] result = new int[cost.length + 1];
        // ��ʼ��dp����
        result[0] = 0;
        result[1] = 0;
        // ���dp����
        for (int i = 2; i < result.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }
        // ���ص���¥�������ٻ���
        return result[result.length - 1];
    }
}
