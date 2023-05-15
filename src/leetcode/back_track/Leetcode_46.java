package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.ȫ����
 * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
 */
public class Leetcode_46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null | nums.length == 0) {
            return result;
        }
        backTrack(nums);
        return result;
    }

    private void backTrack(int[] nums) {
        System.out.println(paths);
        if (paths.size() == nums.length) {
            result.add(new ArrayList<>(paths));
        }
        for (int i = 0; i < nums.length; i++) {
            if (paths.contains(nums[i])) {
                continue;
            }
            paths.add(nums[i]);
            backTrack(nums);
            paths.remove(paths.size() - 1);
        }
    }
}
