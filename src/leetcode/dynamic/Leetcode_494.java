package leetcode.dynamic;

import java.util.Arrays;

/**
 * 494.Ŀ���
 * ����һ���������� nums ��һ������ target ��
 * �������е�ÿ������ǰ��� '+' �� '-' ��Ȼ�������������������Թ���һ�� ���ʽ ��
 * ���磬nums = [2, 1] �������� 2 ֮ǰ��� '+' ���� 1 ֮ǰ��� '-' ��Ȼ���������õ����ʽ "+2-1" ��
 * ���ؿ���ͨ��������������ġ����������� target �Ĳ�ͬ ���ʽ ����Ŀ��
 */
public class Leetcode_494 {
    /**
     * left(����)��right(����)��sum(�����)��target(Ŀ���)
     * left + right = sum
     * left - right = target
     * left = (sum + target) / 2
     * �������ת��Ϊ01�������� ��������ڼ���nums���ҳ���Ϊleft�����
     *
     * @param nums   �������������
     * @param target Ŀ���
     * @return ��ΪĿ��͵������
     */
    public int findTargetSumWays(int[] nums, int target) {
        // ����������ܺ�
        int sum = Arrays.stream(nums).sum();
        // ��� (sum + target) ����2������Ϊ1��˵���޷��ҵ�����Ҫ�����ϣ�ֱ�ӷ���0
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        // ��� target �Ǹ����� sum С�� -target��˵���޷��ҵ�����Ҫ�����ϣ�ֱ�ӷ���0
        if (target < 0 && sum < -target) {
            return 0;
        }
        // ����Ŀ��͵�һ�룬��ȡ����ֵ
        int size = (sum + target) / 2;
        if (size < 0) {
            size = -size;
        }
        // ����������飬��ʾ��Ϊi�������
        int[] result = new int[size + 1];
        // ��ʼ����Ϊ0�������Ϊ1
        result[0] = 1;
        // �������� nums
        for (int i = 0; i < nums.length; i++) {
            // �ӽ����������һ��Ԫ�ؿ�ʼ��ǰ����
            for (int j = result.length - 1; j >= nums[i]; j--) {
                // ���������������ǰ���� nums[i] ���뵽��Ϊ j �������
                result[j] += result[j - nums[i]];
            }
        }
        // ���ؽ����������һ��Ԫ�أ�����ʾ��ΪĿ��ֵ�������
        return result[result.length - 1];
    }
}