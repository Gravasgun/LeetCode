package leetcode.back_track;

import java.util.*;

/**
 * 47.ȫ����II
 * ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�
 */

public class Leetcode_47 {
    List<List<Integer>> result = new ArrayList<>();  // ���ڴ洢���յ����н��
    List<Integer> paths = new ArrayList<>();  // ���ڴ洢��ǰ������·��
    boolean[] used;  // ��¼Ԫ�ص�ʹ�����

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];  // ��ʼ��used���飬Ĭ��ֵΪfalse
        Arrays.sort(nums);  // ������������������Ա�ȥ��
        backTrack(nums);  // ��ʼ������������
        return result;
    }

    private void backTrack(int[] nums) {
        if (paths.size() == nums.length) {  // ��·�����ȵ������鳤��ʱ����ʾ�Ѿ�������һ������
            result.add(new ArrayList<>(paths));  // ����ǰ���м�������
            return;
        }
        Set<Integer> set = new HashSet<>();  // ����ȥ�صļ���
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {  // ����������Ѿ������˵�ǰԪ�أ�������Ԫ��
                continue;
            }
            if (used[i]) {  // �����ǰԪ���Ѿ���ʹ�ù���������Ԫ��
                continue;
            }
            set.add(nums[i]);  // ����ǰԪ�ؼ��뼯���У���ʾ�Ѿ�ʹ�ù�
            used[i] = true;  // ����ǰԪ�ر��Ϊ��ʹ��
            paths.add(nums[i]);  // ����ǰԪ�ؼ���·����
            backTrack(nums);  // �ݹ�������һ��λ�õ�Ԫ��
            paths.remove(paths.size() - 1);  // ���ݣ��Ƴ���ǰλ�õ�Ԫ��
            used[i] = false;  // ����ǰԪ�ر��Ϊδʹ�ã��Ա����λ�õ�Ԫ��ʹ��
        }
    }
}