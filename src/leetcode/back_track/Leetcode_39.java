package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39.����ܺ�
 * ����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target
 * �ҳ� candidates �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ���,�����б���ʽ���ء�����԰� ����˳�� ������Щ��ϡ�
 * candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 * ���ڸ��������룬��֤��Ϊ target �Ĳ�ͬ��������� 150 ����
 */
public class Leetcode_39 {
    List<List<Integer>> result = new ArrayList<>(); // �洢���ս�����б�
    List<Integer> paths = new ArrayList<>(); // �洢��ǰ��ϵ�·��

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result; // ���������������ѡ����Ϊ�գ�ֱ�ӷ��ؿս���б�
        }
        Arrays.sort(candidates); // �Ժ�ѡ�����������Ϊ�˺�����֦����
        backTrack(candidates, target, 0); // �����㷨���
        return result; // �������յĽ���б�
    }

    private void backTrack(int[] candidates, int target, int startIndex) {
        int total = paths.stream().mapToInt(Integer::intValue).sum();
        if (total == target) {
            result.add(new ArrayList<>(paths)); // ��ǰ·���ĺ͵���Ŀ��ֵ������ǰ·����ӵ�����б���
            return; // ������һ��ݹ�
        }
        if (total > target) {
            return; // ��ǰ·���ĺ��Ѿ�����Ŀ��ֵ����ֹ��ǰ·��������
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue; // ������ͬ�����֣����������ظ������
            }
            paths.add(candidates[i]); // ����ǰ���ּ���·����
            total += candidates[i]; // ���µ�ǰ·���ĺ�
            backTrack(candidates, target, i); // �ݹ���ã�����������һ������
            total -= candidates[i]; // �ָ���ǰ·���ĺͣ�׼������������֧
            paths.remove(paths.size() - 1); // �Ƴ���ǰ���֣����ݵ���һ��
        }
    }
}
