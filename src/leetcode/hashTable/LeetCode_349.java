package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_349 {
    /**
     * 349.��������Ľ���
     * ������������nums1��nums2���������ǵĽ������������е�ÿ��Ԫ��һ����Ψһ�ġ����ǿ��Բ�������������˳��
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        // ��Ž����֮������set��Ϊ�˸������ȥ��
        Set<Integer> result = new HashSet<>();

        //��nums1�е�ÿ��Ԫ�ط���set,Ŀ����ȥ��
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            //���set�а�����nums2�е�Ԫ��
            if (set.contains(nums2[i])) {
                //��result����ӣ�Ŀ����ȥ��
                result.add(nums2[i]);
            }
        }
        //��resultת��Ϊ����
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
