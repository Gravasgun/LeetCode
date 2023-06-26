package leetcode.dynamic;

public class Leetcode_343 {
    public int integerBreak(int n) {
        // result[i]:�������i�����˻�Ϊresult[i]
        int[] result = new int[n + 1];
        // ��ʼ��dp����
        result[2] = 1;
        // ���dp����
        for (int i = 3; i < result.length; i++) {
            for (int j = 1; j < i; j++) {
                result[i] = Math.max(result[i], Math.max(j * (i - j), j * result[i - j]));
            }
        }
        // ���ز������i�����˻� result[i]
        return result[result.length - 1];
    }
}
