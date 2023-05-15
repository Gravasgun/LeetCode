package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.�Ӽ�II
 * ����һ���������� nums �����п��ܰ����ظ�Ԫ�أ����㷵�ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ������صĽ⼯�У��Ӽ����԰� ����˳�� ���С�
 */
public class Leetcode_90 {
    List<List<Integer>> result = new ArrayList<>(); // �洢�����Ӽ�������б�
    List<Integer> subSet = new ArrayList<>(); // ��ǰ���ڹ������Ӽ�

    /**
     * ���ɸ�������������Ӽ������п��ܰ����ظ���Ԫ��
     * @param nums ��������������
     * @return ���������Ӽ����б�
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result; // ����Ϊ�ջ򳤶�Ϊ0��ֱ�ӷ��ؽ���б�
        }
        Arrays.sort(nums); // ��������������Դ����ظ�Ԫ��
        backTrack(nums, 0); // ���û��ݷ��������Ӽ�
        return result; // ���ؽ���б�
    }

    /**
     * ���ݷ����������Ӽ�
     * @param nums ��������������
     * @param startIndex ��ǰ���ݵ���ʼ����
     */
    private void backTrack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subSet)); // ����ǰ�Ӽ����뵽����б���
        for (int i = startIndex; i < nums.length; i++) {
            if (startIndex != i && nums[i] == nums[i - 1]) {
                continue; // �����ظ���Ԫ�أ����������ظ����Ӽ�
            }
            subSet.add(nums[i]); // ����ǰԪ�ؼ��뵽�Ӽ���
            backTrack(nums, i + 1); // �ݹ���û��ݣ�������ʼ����Ϊi+1
            subSet.remove(subSet.size() - 1); // ���ݣ��Ƴ����һ��Ԫ�أ�������һ�ֻ���
        }
    }
}