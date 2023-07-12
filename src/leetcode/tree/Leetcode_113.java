package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // ���ڴ洢����������·�����б�
        List<List<Integer>> result = new ArrayList<>();
        // ������ڵ�Ϊ�գ���ֱ�ӷ��ؿյĽ���б�
        if (root == null) {
            return result;
        }
        // ���ڴ洢��ǰ·�����б�
        List<Integer> paths = new ArrayList<>();
        // ���л�������
        backTracking(root, targetSum, result, paths);
        // �������ս��
        return result;
    }

    private void backTracking(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> paths) {
        // ����ǰ�ڵ��ֵ��ӵ�·���б���
        paths.add(root.val);
        // �����ǰ�ڵ�ΪҶ�ӽڵ���·���͵���Ŀ��ͣ��򽫸�·����ӵ�����б���
        if (root.left == null && root.right == null && paths.stream().mapToInt(Integer::intValue).sum() == targetSum) {
            result.add(new ArrayList<>(paths));
            // ���ݵ���һ��ڵ�
            return;
        }
        if (root.left != null) {
            // �ݹ鴦��������
            backTracking(root.left, targetSum, result, paths);
            // ���ݵ���һ��ڵ�֮ǰ������ǰ�ڵ��·���б����Ƴ�
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            // �ݹ鴦��������
            backTracking(root.right, targetSum, result, paths);
            // ���ݵ���һ��ڵ�֮ǰ������ǰ�ڵ��·���б����Ƴ�
            paths.remove(paths.size() - 1);
        }
    }
}
