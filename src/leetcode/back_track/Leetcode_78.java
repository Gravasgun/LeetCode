package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.�Ӽ�
 * ����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 */
public class Leetcode_78 {
    List<List<Integer>> result = new ArrayList<>(); // �洢���ս�����б�
    List<Integer> subSet = new ArrayList<>(); // ��ǰ�������ɵ��Ӽ�

    /**
     * ���ظ���������������п����Ӽ�
     * @param nums ��������������
     * @return ���п��ܵ��Ӽ��б�
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result; // ����Ϊ�գ�ֱ�ӷ��ؿ��б�
        }
        backTrack(nums, 0); // ��ʼ�����Ӽ�
        return result;
    }

    /**
     * �����㷨�����Ӽ�
     * @param nums ��������������
     * @param startIndex ��ǰ���ݵ���ʼ����
     */
    private void backTrack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subSet)); // ����ǰ�Ӽ���ӵ��������
        if (startIndex >= nums.length) {
            return; // �������鷶Χ�������ݹ�
        }
        for (int i = startIndex; i < nums.length; i++) {
            subSet.add(nums[i]); // ����ǰԪ�ؼ��뵱ǰ�Ӽ�
            backTrack(nums, i + 1); // �ݹ�������һ���Ӽ�����ʼ����Ϊ��ǰԪ�ص���һ��λ��
            subSet.remove(subSet.size() - 1); // ���ݲ����������һ�������Ԫ���Ƴ�������������һ���Ӽ�
        }
    }
}