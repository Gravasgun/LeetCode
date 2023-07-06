package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_674 {
    public int findLengthOfLCISMethodOne(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < result.length; i++) {
            if (nums[i] > nums[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }

    /**
     * ��������������������������еĳ���
     *
     * @param nums ����������
     * @return ��������������еĳ���
     */
    public static int findLengthOfLCISMethodTwo(int[] nums) {
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
