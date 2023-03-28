package leetcode.arrayList.singleNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_217 {
    /**
     * 217.�����ظ�Ԫ��
     * ����һ����������nums�������һֵ�������г����������Σ�����true�����������ÿ��Ԫ�ػ�����ͬ������false ��
     *
     * @param nums
     * @return
     */
    //����һ����ϣset
    public boolean containsDuplicateMethodOne(int[] nums) {
        /**
         * ˼·������������ÿ��Ԫ�أ����ǽ������뵽��ϣ���С��������һ��Ԫ��ʱ���ָ�Ԫ���Ѿ������ڹ�ϣ���У���˵�������ظ���Ԫ�ء�
         */
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    //������������
    public boolean containsDuplicateMethodTwo(int[] nums) {
        /**
         * ˼·���ڶ����ִ�С��������֮��������ظ�Ԫ��һ������������λ���С���ˣ����ǿ���ɨ������������飬ÿ���ж����ڵ�����Ԫ���Ƿ���ȣ���������˵�������ظ���Ԫ�ء�
         */
        Arrays.sort(nums);
        //ѭ��������nums.length - 1�������Ƚ�ʱѭ����������1
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
