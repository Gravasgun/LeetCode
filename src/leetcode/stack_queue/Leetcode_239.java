package leetcode.stack_queue;

/**
 * 239.�����������ֵ
 * ����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ��
 * ���� ���������е����ֵ ��
 */
public class Leetcode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1]; // �洢���������
        int index = 0; // ���������±�
        for (int i = 0; i <= n - k; i++) { // ����ÿ����������
            int max = Integer.MIN_VALUE; // ��ǰ���ڵ����ֵ����ʼֵΪ�������
            for (int j = i; j < i + k; j++) { // ���������ڵ�Ԫ��
                max = Math.max(max, nums[j]); // �ҳ���ǰ�����ڵ����ֵ
            }
            result[index++] = max; // ����ǰ���ڵ����ֵ���뵽���������
        }
        return result;
    }
}