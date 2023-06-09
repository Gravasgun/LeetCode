package leetcode.dynamic;

import java.util.Arrays;

/**
 * 300.�����������
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 * ������ ���������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳��
 * ���磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 */
public class Leetcode_300 {
    public int lengthOfLIS(int[] nums) {
        // ����һ��dp��������¼ÿ��λ�õ�����������г���
        // result[i]��ʾi֮ǰ����i�� ��nums[i]��β ������������еĳ���
        int[] result = new int[nums.length];
        // ������ result ��ʼ��Ϊ1����Ϊÿ��Ԫ�ر������ɳ���Ϊ1�ĵ���������
        Arrays.fill(nums, 1);
        // �������飬����ÿ��λ�õ�����������г���
        for (int i = 1; i < result.length; i++) {
            // �����ǰ���ִ���ǰ������֣����Խ���ǰ���ּ��뵽ǰ��ĵ����������У����������
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        // ��������������еĳ��ȣ��� result �����е����ֵ
        return Arrays.stream(result).max().getAsInt();
    }
}
