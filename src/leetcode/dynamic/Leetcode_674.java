package leetcode.dynamic;

import java.util.Arrays;

/**
 * 674.�������������
 * ����һ��δ��������������飬�ҵ���� ���������������У������ظ����еĳ��ȡ�
 * ���������������� �����������±� l �� r��l < r��ȷ�����������ÿ�� l <= i < r
 * ���� nums[i] < nums[i + 1] ����ô������ [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] �����������������С�
 */
public class Leetcode_674 {
    public int findLengthOfLCIS(int[] nums) {
        // ����һ��dp��������¼��ÿ��λ�ý�β����������������еĳ���
        int[] result = new int[nums.length];
        // ������ result ��ʼ��Ϊ1����Ϊÿ��Ԫ�ر������ɳ���Ϊ1����������������
        Arrays.fill(result, 1);
        // �������飬������ÿ��λ�ý�β����������������еĳ���
        for (int i = 1; i < result.length; i++) {
            // �����ǰ���ִ���ǰһ�����֣�����Խ���ǰ���ּ��뵽ǰ�������������������
            if (nums[i] > nums[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        // ������������������еĳ��ȣ��� result �����е����ֵ
        return Arrays.stream(result).max().getAsInt();
    }
}