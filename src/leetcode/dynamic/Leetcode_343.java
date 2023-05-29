package leetcode.dynamic;

/**
 * 343.�������
 * ����һ�������� n ��������Ϊ k �� ������ �ĺͣ� k >= 2 ������ʹ��Щ�����ĳ˻���󻯡�
 * ���� ����Ի�õ����˻� ��
 */
public class Leetcode_343 {
    public int integerBreak(int n) {
        // ����dp�������ڱ��潫���ֲ�ֺ�õ��ĳ˻������ֵ
        // dp[i]���ֲ�����i�����Եõ������˻�Ϊdp[i]
        int[] result = new int[n + 1];
        // ��ʼ�����������2��ֺ�õ��ĳ˻����Ϊ1
        result[2] = 1;
        // ������3��ʼ�����ֺ�ĳ˻����ֵ
        for (int i = 3; i < result.length; i++) {
            // �������п��ܵĲ�����
            for (int j = 1; j < i; j++) {
                // �Ƚ� ��ǰ�Ĳ����� j���Բ��ʣ�ಿ�ֵĳ˻����ֵ �� j����(i - j)��ֵ��ȡ�ϴ���
                // j * dp[i - j]���൱���ǲ��(i - j)
                result[i] = Math.max(result[i], Math.max(j * result[i - j], j * (i - j)));
            }
        }
        // ���ؽ�����n��ֺ�õ��ĳ˻������ֵ
        return result[result.length - 1];
    }
}
