package leetcode.arrayList.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {
    /**
     * 15.����֮��
     * ����һ����������nums���ж��Ƿ������Ԫ��[nums[i], nums[j], nums[k]]����
     * i != j��i != k �� j != k ��ͬʱ������ nums[i] + nums[j] + nums[k] == 0��
     * ���㷵�����к�Ϊ0�Ҳ��ظ�����Ԫ�顣
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length; left++) {
            //��������ĵ�һ����������0�ˣ���ô�Ͳ����ܳ�����Ԫ����
            if (nums[left] > 0) {
                return result;
            }

            //ȥ��left
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }

            int temp = left + 1;
            int right = nums.length - 1;
            while (temp < right) {
                int sum = nums[left] + nums[temp] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    temp++;
                } else {
                    result.add(Arrays.asList(nums[left], nums[temp], nums[right]));
                    //�ҵ���Ԫ��֮��ȥ��temp��right
                    while (temp < right && nums[temp] == nums[temp + 1]) {
                        temp++;
                    }
                    while (temp < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //�ƶ�ָ��
                    right--;
                    temp++;
                }
            }
        }
        return result;
    }

}
