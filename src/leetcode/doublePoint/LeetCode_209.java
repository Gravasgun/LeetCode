package leetcode.doublePoint;

import org.junit.Test;

public class LeetCode_209 {
    /**
     * 209. ������С��������
     * ����һ������n���������������һ��������target��
     * �ҳ���������������͡�target�ĳ�����С�����������飬�������䳤�ȡ���������ڷ��������������飬����0��
     *
     * @param target
     * @param nums
     * @return
     */
    //˫ѭ�������ⷨ
    public int minSubArrayLenMethodOne(int target, int[] nums) {
        //���յĽ��
        int result = Integer.MAX_VALUE;
        //������֮��
        int sum = 0;
        //�����еĳ���
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) {
            //ÿ��һ��sum����
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                //�����к�
                sum += nums[j];
                //һ�����������кͳ�����target������result
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = result < subLength ? result : subLength;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //˫ָ��
    public int minSubArrayLenMethodTwo(int target, int[] nums) {
        //���յĽ��
        int result = Integer.MAX_VALUE;
        //������֮��
        int sum = 0;
        //��ָ��
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            //�����к�
            sum += nums[right];
            //�������еĺ�>targetʱ����������߿�ʼ���������еĺ����ݼ�����
            while (sum >= target) {
                //���³���
                result = Math.min(right-left+1, result);
                //���������еĺ�
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
