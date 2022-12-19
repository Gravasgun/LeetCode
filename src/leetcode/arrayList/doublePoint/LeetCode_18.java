package leetcode.arrayList.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18 {
    /**
     * 18.����֮��
     * ����һ����n��������ɵ�����nums����һ��Ŀ��ֵtarget��
     * �����ҳ���������������ȫ�������Ҳ��ظ�����Ԫ��[nums[a], nums[b], nums[c], nums[d]]
     * ����������Ԫ��Ԫ��һһ��Ӧ������Ϊ������Ԫ���ظ�����
     * 0 <= a, b, c, d < n
     * a��b��c �� d ������ͬ
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //�����һ����������target���������п϶��Ҳ���
            //nums[i]>0��Ϊ���ų�������� [-4,-1,0,0] target= -5
            if (nums[i] > 0 && nums[i] > target && target > 0) {
                return result;
            }

            //��nums[i]ȥ��
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                //nums[j]ȥ��
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //nums[right]ȥ��
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //nums[left]ȥ��
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //�ƶ�ָ��
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
