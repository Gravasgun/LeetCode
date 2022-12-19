package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_454 {
    /**
     * 454.�������II
     * �����ĸ���������nums1��nums2��nums3��nums4 �����鳤�ȶ���n����������ж��ٸ�Ԫ�� (i, j, k, l) �����㣺
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        //ͳ�����������е�Ԫ��֮�ͣ�ͬʱͳ�Ƴ��ֵĴ���������map
        for (int i : nums1) {
            for (int j : nums2) {
                sum = i + j;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        //ͳ��ʣ�������Ԫ�صĺͣ���map�����Ƿ�������Ϊ0�������ͬʱ��¼����
        for (int i : nums3) {
            for (int j : nums4) {
                sum = 0 - (i + j);
                if (map.containsKey(sum)) {
                    result += map.get(sum);
                }
            }
        }
        return result;
    }
}
