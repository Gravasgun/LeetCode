package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.����ܺ�II
 * ����һ����ѡ�˱�ŵļ��� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * candidates �е�ÿ��������ÿ�������ֻ��ʹ�� һ�� ��
 * ע�⣺�⼯���ܰ����ظ�����ϡ�
 */
public class Leetcode_40 {
    List<List<Integer>> result = new ArrayList<>(); // �洢���ս�����б�
    List<Integer> paths = new ArrayList<>(); // �洢��ǰ·�����б�
    int sum = 0; // ��ǰ·���ĺ�

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates); // �Ժ�ѡ�����������
        backTrack(candidates, target, 0); // ���û��ݷ���
        return result;
    }

    private void backTrack(int[] candidates, int target, int startIndex) {
        if (sum == target) { // �� ��ǰ·���ĺ͵���Ŀ��ֵʱ������ǰ·�����뵽�������
            result.add(new ArrayList<>(paths));
            return;
        }
        if (sum > target) { // �� ��ǰ·���ĺʹ���Ŀ��ֵʱ�����ݵ���һ��
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) { // ������ѡ����
            if (sum > target || candidates[i] > target) { // ��ǰ·���ʹ���Ŀ��ֵ��ǰ��ѡ������Ŀ��ֵʱ��������ǰѭ��
                break;
            }
            if (i > startIndex && candidates[i] == candidates[i - 1]) { // �����ظ��ĺ�ѡ�������������ظ������
                continue;
            }
            sum += candidates[i]; // ����ǰ��ѡ�����뵽��ǰ·����
            paths.add(candidates[i]);
            backTrack(candidates, target, i + 1); // �ݹ���û��ݷ�����������һ��Ľ�
            sum -= candidates[i]; // ���ݣ�����ǰ��ѡ���ӵ�ǰ·�����Ƴ�
            paths.remove(paths.size() - 1);
        }
    }
}
