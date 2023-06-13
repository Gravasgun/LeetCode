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
     * @param nums ��������
     * @return ����������
     */
    public int maxSubArrayMethodOne(int[] nums) {
        // ��������Ƿ�Ϊ�ջ򳤶�Ϊ��
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // ���ڼ�¼��ǰ�����ͣ���ʼֵ����Ϊ��������Сֵ
        int result = Integer.MIN_VALUE;
        // ���ڼ�¼��ǰ����������ĺ�
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // ����ǰԪ�ؼӵ� sum ��
            sum += nums[i];
            // �������� result��ȡ sum �� result �нϴ��ֵ��Ϊ�µ� result
            result = Math.max(sum, result);
            // ��� sum С�ڵ��� 0���� sum ����Ϊ 0����Ϊ�����Ժ���������ĺ�ֻ���������Ӱ�죬��������
            if (sum <= 0) {
                sum = 0;
            }
        }
        return result; // ������������
    }

    /**
     * �������������ⷨ
     *
     * @param nums ��������
     * @return ����������
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
            int temp = 0; // ��ʱ�������ڼ��㵱ǰ������ĺ�

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

    /**
     * ����������̬�滮
     *
     * @param nums ��������
     * @return ����������
     */
    public int maxSubArrayMethodThree(int[] nums) {
        // ��������Ƿ�Ϊ�ջ򳤶�Ϊ��
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // ���ڼ�¼�Ե�ǰԪ��Ϊ��β�������������
        int[] result = new int[nums.length];
        // ��ʼ����һ��Ԫ�ص�����Ϊ����
        result[0] = nums[0];
        // ���ڼ�¼���������ͣ���ʼֵΪ��һ��Ԫ��
        int max = nums[0];
        for (int i = 1; i < result.length; i++) {
            // ״̬ת�Ʒ��̣�ȡ��ǰԪ�غ͵�ǰԪ�ؼ���ǰһ��Ԫ�ؽ�β��������������еĽϴ�ֵ
            result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
            max = Math.max(max, result[i]); // ��������������
        }
        // ��������������
        return max;
    }
}