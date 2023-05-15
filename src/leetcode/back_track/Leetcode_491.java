package leetcode.back_track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 491.����������
 * ����һ���������� nums ���ҳ����������и������в�ͬ�ĵ��������У������������� ����������Ԫ�� ������԰� ����˳�� ���ش𰸡�
 * �����п��ܺ����ظ�Ԫ�أ����������������ȣ�Ҳ���������������е�һ�����������
 */
public class Leetcode_491 {
    // �洢���е��������еĽ���б�
    List<List<Integer>> result = new ArrayList<>();
    // ��ǰ���ڹ����ĵ���������
    List<Integer> subSequence = new ArrayList<>();

    // Ѱ�Ҹ�������ĵ��������е���ڷ���
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backTrack(nums, 0);
        return result;
    }

    // ���ݷ��������ڹ�������������
    private void backTrack(int[] nums, int startIndex) {
        // �����ǰ�����г��ȴ���1������������б���
        if (subSequence.size() > 1) {
            result.add(new ArrayList<>(subSequence));
        }

        // ʹ��Map��¼��ǰ�㼶���Ѿ�������Ԫ�أ��Ա����ظ�
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            // �����ǰ�����в�Ϊ�գ����ҵ�ǰԪ��С���������е����һ��Ԫ�أ���������Ԫ�أ���֤����
            if (!subSequence.isEmpty() && subSequence.get(subSequence.size() - 1) > nums[i]) {
                continue;
            }

            // ���Map���Ѿ����ڵ�ǰԪ�أ���������Ԫ�أ������ظ�
            if (map.containsKey(nums[i])) {
                continue;
            } else {
                map.put(nums[i], 1);
            }

            // ����ǰԪ�ؼ��뵽��ǰ��������
            subSequence.add(nums[i]);
            // �ݹ����backTrack������������󹹽�������
            backTrack(nums, i + 1);
            // ���ݣ��Ƴ����һ����ӵ�Ԫ�أ��Ա������һ�ֵ���
            subSequence.remove(subSequence.size() - 1);
        }
    }
}