package leetcode.dynamic;

public class Leetcode_96 {
    public int numTrees(int n) {
        // dp[i]���ڵ�����Ϊi�Ĳ�ͬ����������������
        int[] result = new int[n + 1];
        // ����
        result[0] = 1;
        // ��һ��ѭ���������ڵ�
        for (int i = 1; i < result.length; i++) {
            // �ڶ���ѭ������������
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        return result[result.length - 1];
    }
}
