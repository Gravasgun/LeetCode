package leetcode.tree;

import java.util.*;

/**
 * 107.�������Ĳ������II
 * ����������ĸ��ڵ�root��������ڵ�ֵ�Ե����ϵĲ����������������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
 */
public class Leetcode_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // ����һ���б�洢���ս��
        List<List<Integer>> result = new ArrayList<>();
        // ����һ�����У����� BFS ����������
        Queue<TreeNode> queue = new LinkedList<>();
        // ������ڵ�Ϊ�գ���ֱ�ӷ��ؽ���б�
        if (root == null) {
            return result;
        }
        // �����ڵ�������
        queue.offer(root);
        // BFS ����������
        while (!queue.isEmpty()) {
            // ��¼��ǰ���еĴ�С
            int size = queue.size();
            // ����һ����ʱ�б����ڴ洢��ǰ��Ľڵ�ֵ
            List<Integer> temp = new ArrayList<>();
            // ������ǰ������нڵ�
            while (size > 0) {
                // �������׽ڵ�
                TreeNode node = queue.poll();
                // ���ڵ�ֵ��ӵ���ʱ�б���
                temp.add(node.val);
                // ������ӽڵ㲻Ϊ�գ������ӽڵ�������
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // ������ӽڵ㲻Ϊ�գ������ӽڵ�������
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // ��ǰ��ڵ������� 1
                size--;
            }
            // ����ʱ�б���ӵ����ս���б���
            result.add(temp);
        }
        // ��ת���ս���б��õ��������ϵĲ���������
        Collections.reverse(result);
        // �������ս���б�
        return result;
    }
}
