package leetcode.greedy;

import java.util.Arrays;

/**
 * 1005.K��ȡ������󻯵������
 * ����һ���������� nums ��һ������ k �������·����޸ĸ����飺
 * ѡ��ĳ���±� i ���� nums[i] �滻Ϊ -nums[i] ��
 * �ظ��������ǡ�� k �Ρ����Զ��ѡ��ͬһ���±� i ��
 * �����ַ�ʽ�޸�����󣬷������� ���ܵ����� ��
 */
public class Leetcode_1005 {
    // �ֲ����ţ��þ���ֵ��ĸ�����Ϊ��������ǰ��ֵ�ﵽ���
    // ȫ�����ţ���������ʹﵽ���
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); // �������������
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) { // �����ǰ����С��0���һ���ʣ���ȡ������
                nums[i] = -1 * nums[i]; // ����ǰ����ȡ��
                k--; // ȡ��������1
            }
        }
        Arrays.sort(nums); // �ٴζ������������
        if (k > 0 && k % 2 == 1) { // ���ʣ��ȡ����������0��Ϊ����
            nums[0] = -1 * nums[0]; // ����������С��Ԫ��ȡ��
        }
        return Arrays.stream(nums).sum(); // ��������������Ԫ�صĺͲ�����
    }
}