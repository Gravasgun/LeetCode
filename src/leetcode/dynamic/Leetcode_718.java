package leetcode.dynamic;

/**
 * 718.��ظ�������
 * �������������� nums1 �� nums2 ������ ���������� ������ ���������������ĳ��� ��
 */
public class Leetcode_718 {
    /**
     * ����һ��������
     *
     * @param nums1 ��һ������
     * @param nums2 �ڶ�������
     * @return �����������ĳ���
     */
    public int findLengthMethodOne(int[] nums1, int[] nums2) {
        // ��ʼ����󳤶�Ϊ��Сֵ
        int max = Integer.MIN_VALUE;
        // ���� nums1 ����
        for (int i = 0; i < nums1.length; i++) {
            // ���� nums2 ����
            for (int j = 0; j < nums2.length; j++) {
                // ��ʼ����ʱ����Ϊ 1
                int temp = 1;
                // �����ǰԪ����ȣ����һ���ȽϺ���Ԫ��
                if (nums1[i] == nums2[j]) {
                    // ��������Ԫ�أ�����Ƚ�
                    for (int k = 1; i + k < nums1.length && j + k < nums2.length; k++) {
                        // �������Ԫ�ز���ȣ�����ֹ�Ƚ�
                        if (nums1[i + k] != nums2[j + k]) {
                            break;
                        }
                        // �������Ԫ����ȣ���ʱ���ȼ�һ
                        temp++;
                    }
                    // ������󳤶�
                    max = Math.max(max, temp);
                }
            }
        }
        // �����󳤶���Ϊ��ʼֵ���򷵻� 0�����򷵻���󳤶�
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /**
     * ����������̬�滮
     *
     * @param nums1 ��һ������
     * @param nums2 �ڶ�������
     * @return �����������ĳ���
     */
    public int findLengthMethodTwo(int[] nums1, int[] nums2) {
        // ������ά�������ڼ�¼����������ĳ���
        // dp[i][j] �����±�i - 1Ϊ��β��nums1[i-1]�������±�j - 1Ϊ��β��nums2[i-2]����ظ������鳤��Ϊdp[i][j]
        // �ر�ע�⣺ �����±�i - 1Ϊ��β��nums1[i-1]�� ����һ���� ��nums1[i-1]Ϊ��β���ַ���
        int[][] result = new int[nums1.length + 1][nums2.length + 1];
        // ��¼���ֵ
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                // �����ǰԪ�����
                if (nums1[i - 1] == nums2[j - 1]) {
                    // ��ǰλ�õĹ��������鳤�ȵ������Ͻ�λ�õĳ��ȼ�һ
                    result[i][j] = result[i - 1][j - 1] + 1;
                    // ������󳤶�
                    max = Math.max(max, result[i][j]);
                }
            }
        }
        // �����󳤶���Ϊ��ʼֵ���򷵻� 0�����򷵻���󳤶�
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}