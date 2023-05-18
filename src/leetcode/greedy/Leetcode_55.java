package leetcode.greedy;

/**
 * 55.��Ծ��Ϸ
 * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * �ж����Ƿ��ܹ��������һ���±ꡣ
 */
public class Leetcode_55 {
    // �ֲ����ţ�ÿ��ȡ�����Ծ������ȡ��󸲸Ƿ�Χ��
    // �������ţ����õ�������󸲸Ƿ�Χ�����Ƿ��ܵ��յ�
    public boolean canJump(int[] nums) {
        // �������ֻ��һ��Ԫ�أ������ֱ���������һ��Ԫ��
        if (nums.length == 1) {
            return true;
        }
        // ��¼��ǰ�ܹ���Ծ�����Χ
        int maxRange = 0;
        // ���������е�ÿ��λ��
        for (int i = 0; i <= maxRange; i++) {
            // ���㵱ǰλ���ܹ���Ծ�����Χ
            int temp = i + nums[i];
            // �������Χ
            maxRange = Math.max(maxRange, temp);
            // ������Χ���ڵ�����������һ���������������Ծ�����һ��Ԫ��
            if (maxRange >= nums.length - 1) {
                return true;
            }
        }
        // �޷���Ծ�����һ��Ԫ��
        return false;
    }
}