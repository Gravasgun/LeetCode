package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.ȫ����
 * ����һ�������ظ����ֵ����� nums �����������п��ܵ�ȫ���С�����԰�����˳�򷵻ش𰸡�
 */
public class Leetcode_46 {
    List<List<Integer>> result = new ArrayList<>();  // ���ڴ洢������б�
    List<Integer> paths = new ArrayList<>();  // ���ڴ洢��ǰ·�����б�

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {  // ������Ϊ�գ���ֱ�ӷ��ؽ���б�
            return result;
        }
        backTrack(nums);  // ���û��ݷ���
        return result;  // ���ؽ���б�
    }

    private void backTrack(int[] nums) {
        if (paths.size() == nums.length) {  // �����ǰ·���ĳ��ȵ�������ĳ��ȣ���ʾ�Ѿ�������һ������
            result.add(new ArrayList<>(paths));  // ����ǰ·�����뵽����б���
        }
        for (int i = 0; i < nums.length; i++) {  // ���������е�ÿ������
            if (paths.contains(nums[i])) {  // �����ǰ·���Ѿ����������֣�˵���������Ѿ���ʹ�ù���ֱ������
                continue;
            }
            paths.add(nums[i]);  // ����ǰ���ּ��뵽��ǰ·����
            backTrack(nums);  // �ݹ�������һ�����ֵ�����
            paths.remove(paths.size() - 1);  // ���ݣ��Ƴ����һ����������֣������������ܵ�����
        }
    }
}