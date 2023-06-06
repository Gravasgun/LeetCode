package leetcode.dynamic;

/**
 * 198.��ҽ���
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�
 * Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 */
public class Leetcode_198 {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // ����dp��������������� dp[i]:[0,i]��Χ�ڵ������
        int[] result = new int[nums.length];
        // ��ʼ��dp�����ǰ����Ԫ��
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        // �ӵ�����Ԫ�ؿ�ʼ��������
        for (int i = 2; i < result.length; i++) {
            // ÿ�����ݿ���ѡ�����ٻ����٣�ѡ�����ٽ�����ķ���
            // �����ٵ�i�����ݣ��������Ϊresult[i-2] + nums[i]
            // �������ٵ�i�����ݣ��������Ϊresult[i-1]
            // ȡ�����еĽϴ�ֵ��Ϊ��ǰ���ݵ�������ٽ��
            result[i] = Math.max(result[i - 1], (result[i - 2] + nums[i]));
        }
        // �������һ�����ݵ�������ٽ��
        return result[result.length - 1];
    }
}