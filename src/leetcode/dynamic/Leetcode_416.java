package leetcode.dynamic;

import java.util.Arrays;

/**
 * 416.�ָ�Ⱥ��Ӽ�
 * ����һ�� ֻ���������� �� �ǿ� ���� nums ��
 * �����ж��Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
 */
public class Leetcode_416 {
    /**
     * ������Գ���Ϊ01�������⣺
     * 1.���������Ϊtarget
     * 2.����Ҫ�������Ʒ���������Ԫ�أ�����Ϊ Ԫ�ص���ֵ����ֵҲΪԪ�ص���ֵ
     * 3.�����������װ����˵���ҵ����ܺ�Ϊ sum / 2 ���Ӽ�
     * 4.������ÿһ��Ԫ���ǲ����ظ�����
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        // ������������Ƿ�Ϊ�ջ򳤶�Ϊ��
        if (nums == null || nums.length == 0) {
            return false;
        }
        // ��������������Ԫ�ص��ܺ�
        int sum = Arrays.stream(nums).sum();
        // ����ܺͲ���ż�������޷������黮��Ϊ����ȵ������Ӽ�
        if (sum % 2 != 0) {
            return false;
        }
        // ����Ŀ��ֵ�����ܺ͵�һ��
        int target = sum / 2;
        // �����������ڼ�¼�ﵽĿ��ֵʱ������Ӽ���
        int[] result = new int[target + 1];
        // ��̬�滮���
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // ����result[j]��ֵΪresult[j]��result[j - nums[i]] + nums[i]�Ľϴ�ֵ
                result[j] = Math.max(result[j], result[j - nums[i]] + nums[i]);
            }
        }
        // ���Ŀ��ֵ����result[target]����ʾ���Խ����黮��Ϊ����ȵ������Ӽ�
        return target == result[target];
    }
}