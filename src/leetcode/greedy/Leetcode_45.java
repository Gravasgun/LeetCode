package leetcode.greedy;

/**
 * 45.��Ծ��ϷII
 * ����һ������Ϊ n �� 0 ������������ nums����ʼλ��Ϊ nums[0]��
 * ÿ��Ԫ�� nums[i] ��ʾ������ i ��ǰ��ת����󳤶ȡ����仰˵��������� nums[i] �����������ת������ nums[i + j] ��:
 * 0 <= j <= nums[i]
 * i + j < n
 * ���ص��� nums[n - 1] ����С��Ծ���������ɵĲ����������Ե��� nums[n - 1]��
 */
public class Leetcode_45 {
    public int jump(int[] nums) {
        // �������ֻ��һ��Ԫ�أ�����Ҫ��Ծ������Ϊ0
        if (nums.length == 1) {
            return 0;
        }
        // ����������
        int result = 0;
        // ��ǰ�ܹ���Ծ�����Χ
        int maxRange = 0;
        // ��ǰ�������ܹ��ﵽ����Զλ��
        int tempRange = 0;
        // ������ǰ�ܹ���Ծ�����Χ
        for (int i = 0; i <= tempRange; i++) {
            // ����ÿ��λ���ܹ���Ծ�����Χ
            maxRange = Math.max(maxRange, i + nums[i]);
            // �����һ�������Χ���ڵ�����������һ�����������Ѿ��������һ��λ�ã����Ӳ���������ѭ��
            if (maxRange >= nums.length - 1) {
                result++;
                break;
            }
            // ����������ǰ�����ڵ���Զλ��ʱ����Ҫ������һ����Ծ
            if (i == tempRange && tempRange < nums.length - 1) {
                result++;
                // ������һ���ĵ�ǰ�������ܹ��ﵽ����Զλ��
                tempRange = maxRange;
            }
        }
        // �������ٲ���
        return result;
    }
}