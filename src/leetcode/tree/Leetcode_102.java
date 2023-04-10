package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.�������Ĳ������
 * ����������ĸ��ڵ�root ��������ڵ�ֵ�Ĳ���������������أ������ҷ������нڵ㣩��
 */
public class Leetcode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // ����һ�����У����ڲ������������
        Queue<TreeNode> queue = new LinkedList<>();
        // ����һ���б����ڴ洢�������
        List<List<Integer>> result = new ArrayList<>();
        // ������ڵ�Ϊ�գ���ֱ�ӷ��ؽ���б�
        if (root == null) {
            return result;
        }
        // �����ڵ�������
        queue.offer(root);
        // ���������е����нڵ�
        while (!queue.isEmpty()) {
            // ��ȡ��ǰ�����еĽڵ���������ǰ��Ľڵ���
            int size = queue.size();
            // ����һ���б����ڴ洢��ǰ��Ľڵ�ֵ
            List<Integer> temp = new ArrayList<>();
            // ������ǰ������нڵ�
            while (size > 0) {
                // �Ӷ�����ȡ��һ���ڵ�
                TreeNode node = queue.poll();
                // ���ýڵ��ֵ���뵽��ǰ��Ľڵ�ֵ�б���
                temp.add(node.val);
                // ����ýڵ�����ӽڵ㲻Ϊ�գ�������뵽������
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // ����ýڵ�����ӽڵ㲻Ϊ�գ�������뵽������
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // ��ǰ��ڵ�����һ
                size--;
            }
            // ����ǰ��Ľڵ�ֵ�б���뵽����б���
            result.add(temp);
        }
        // ���ؽ���б�
        return result;
    }
}
