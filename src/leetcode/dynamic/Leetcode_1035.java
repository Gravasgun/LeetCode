package leetcode.dynamic;

/**
 * 1035.���ཻ����
 * ������������ˮƽ���ϰ�������˳��д�� nums1 �� nums2 �е�������
 * ���ڣ����Ի���һЩ������������ nums1[i] �� nums2[j] ��ֱ�ߣ���Щֱ����Ҫͬʱ�������㣺
 * nums1[i] == nums2[j]
 * �һ��Ƶ�ֱ�߲����κ��������ߣ���ˮƽ�ߣ��ཻ��
 * ��ע�⣬���߼�ʹ�ڶ˵�Ҳ�����ཻ��ÿ������ֻ������һ�����ߡ�
 * �����ַ������������������ؿ��Ի��Ƶ������������
 */
public class Leetcode_1035 {
    /**
     * ���ཻ����
     *
     * @param nums1 ��һ����������
     * @param nums2 �ڶ�����������
     * @return ���ཻ���ߵ��������
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // ������ά����result�����ڼ�¼���ཻ���ߵ�����
        int[][] result = new int[nums1.length + 1][nums2.length + 1];
        // ����nums1��nums2��ÿ�����֣����result����
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // ��ǰ������ȣ����Թ���һ�����ཻ����
                if (nums1[i - 1] == nums2[j - 1]) {
                    // ��ǰһ��״̬�Ļ����ϼ�1����ʾ��ǰ���ֱ������ڲ��ཻ������
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // ��ǰ���ֲ���ȣ��޷����ɲ��ཻ����
                    // ѡ��ǰһ��״̬�е�����ѡ���еĽϴ�ֵ
                    // 1. ȥ��nums1�ĵ�ǰ���֣�����nums2����
                    // 2. ȥ��nums2�ĵ�ǰ���֣�����nums1����
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        // �������ս������result�������½ǵ�ֵ����ʾ���ཻ���ߵ��������
        return result[result.length - 1][result[0].length - 1];
    }
}
