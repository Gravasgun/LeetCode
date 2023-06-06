package leetcode.dynamic;

/**
 * 213.��ҽ���II
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ��
 * ����ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽�
 */
public class Leetcode_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // ������������µĽϴ�ֵ��
        // 1. �ӵ�һ�䷿�ݵ������ڶ��䷿�ݽ�������
        // 2. �ӵڶ��䷿�ݵ����һ�䷿�ݽ�������
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int startIndex, int endIndex) {
        // ����һ�����������������
        int[] result = new int[endIndex - startIndex + 1];
        // ��ʼ�������ǰ����Ԫ��
        result[0] = nums[startIndex];
        if (endIndex - startIndex >= 1) {
            result[1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        }
        // �ӵ�����Ԫ�ؿ�ʼ��������
        for (int i = 2; i < result.length; i++) {
            // ÿ�����ݿ���ѡ�����ٻ����٣�ѡ�����ٽ�����ķ���
            // �����ٵ�i�����ݣ��������Ϊresult[i-2] + nums[i+startIndex]
            // �������ٵ�i�����ݣ��������Ϊresult[i-1]
            // ȡ�����еĽϴ�ֵ��Ϊ��ǰ���ݵ�������ٽ��
            result[i] = Math.max(result[i - 1], (result[i - 2] + nums[i + startIndex]));
        }
        // �������һ�����ݵ�������ٽ��
        return result[result.length - 1];
    }
}