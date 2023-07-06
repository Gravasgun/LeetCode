package leetcode.dynamic;

import java.util.Arrays;

/**
 * 674.�������������
 * ����һ��δ��������������飬�ҵ���� ���������������У������ظ����еĳ��ȡ�
 * ���������������� �����������±� l �� r��l < r��ȷ�����������ÿ�� l <= i < r
 * ���� nums[i] < nums[i + 1] ����ô������ [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] �����������������С�
 */
public class Leetcode_674 {
    public int findLengthOfLCISMethodOne(int[] nums) {
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

    /**
     * ��������������������������еĳ���
     *
     * @param nums ����������
     * @return ��������������еĳ���
     */
    public int findLengthOfLCISMethodTwo(int[] nums) {
        int result = 1; // ��������������еĳ�ʼ����Ϊ1
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = 1; // ���ڼ�¼��ǰ���������еĳ���
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    temp += 1; // ��ǰԪ�ش���ǰһ��Ԫ�أ����������г��ȼ�1
                    i++; // �ƶ�ָ�뵽��һ��Ԫ��
                    result = Math.max(result, temp); // ������������������еĳ���
                } else {
                    break; // ��ǰԪ��С�ڵ���ǰһ��Ԫ�أ�����������������������ڲ�ѭ��
                }
            }
        }
        return result; // ������������������еĳ���
    }
}