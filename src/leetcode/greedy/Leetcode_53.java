package leetcode.greedy;

/**
 * 53.����������
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ������ �������е�һ���������֡�
 */
public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE; // ���ڼ�¼��ǰ�����ͣ���ʼֵ����Ϊ��������Сֵ
        int sum = 0; // ���ڼ�¼��ǰ����������ĺ�

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // ����ǰԪ�ؼӵ� sum ��
            result = Math.max(sum, result); // �������� result��ȡ sum �� result �нϴ��ֵ��Ϊ�µ� result

            if (sum <= 0) {
                sum = 0; // ��� sum С�ڵ��� 0���� sum ����Ϊ 0����Ϊ�����Ժ���������ĺ�ֻ���������Ӱ�죬��������
            }
        }
        return result; // ������������
    }
}