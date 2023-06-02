package leetcode.dynamic;

/**
 * 377.����ܺ͢�
 * ����һ���� ��ͬ ������ɵ����� nums ����һ��Ŀ������ target ������� nums ���ҳ��������ܺ�Ϊ target ��Ԫ����ϵĸ�����
 * ��Ŀ���ݱ�֤�𰸷��� 32 λ������Χ��
 *
 * ������������ ��518.��Ǯ�һ�II �������
 */
public class Leetcode_377 {
    public int combinationSum4(int[] nums, int target) {
        // ����һ������Ϊtarget + 1��dp���飬���ڴ洢������
        // dp[i]: �ճ�Ŀ��������Ϊi�����и���Ϊdp[i]
        int[] result = new int[target + 1];
        // ��result[0]��ʼ��Ϊ1����ʾ���Ŀ��ֵΪ0���������Ϊ1
        result[0] = 1;
        // ���ѭ������result����(����)���ڲ�ѭ������nums����(��Ʒ)
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // �жϵ�ǰĿ��ֵi�Ƿ���ڵ���nums[j]
                if (i >= nums[j]) {
                    // �������ʹ��nums[j]�����Ŀ��ֵi��
                    // ��result[i]����result[i - nums[j]]
                    // ��ʾ��nums[j]������Ϻ���Ȼ�������Ŀ��ֵi
                    result[i] += result[i - nums[j]];
                }
            }
        }
        // ����result��������һ��Ԫ�أ�
        // ��ʾʹ�ø��������е�Ԫ�����Ŀ��ֵ�����п�����ϵ�����
        return result[result.length - 1];
    }
}
