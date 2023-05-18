package leetcode.greedy;

/**
 * 53.����������
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ������ �������е�һ���������֡�
 */
public class Leetcode_53 {
    /**
     * ����һ��̰��
     *
     * @param nums
     * @return
     */
    public int maxSubArrayMethodOne(int[] nums) {
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

    /**
     * �������������ⷨ
     *
     * @param nums
     * @return
     */
    public int maxSubArrayMethodTwo(int[] nums) {
        // ��������Ƿ�Ϊ�ջ򳤶�Ϊ��
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // ��ʼ������Ϊ������Сֵ
        int result = Integer.MIN_VALUE;
        // �ⲿѭ����������Ԫ��
        for (int i = 0; i < nums.length; i++) {
            // ��ʱ�������ڼ��㵱ǰ������ĺ�
            int temp = 0;
            // �ڲ�ѭ�������ӵ�ǰλ�õ�����ĩβ��������
            for (int j = i; j < nums.length; j++) {
                // �ۼӵ�ǰ�������Ԫ�ص���ʱ����
                temp += nums[j];
                // ��������Ϊ��ʱ�����͵�ǰ��֪�������еĽϴ�ֵ
                result = Math.max(temp, result);
            }
        }
        // ��������
        return result;
    }
}