package leetcode.tree;

import java.util.*;

/**
 * 515.��ÿ�������������ֵ
 * ����һ�ö������ĸ��ڵ�root�����ҳ��ö�������ÿһ������ֵ��
 */
public class Leetcode_515 {
    public List<Integer> largestValues(TreeNode root) {
        // ��ʼ������б�
        List<Integer> list = new ArrayList<>();
        // ��ʼ������
        Queue<TreeNode> queue = new LinkedList<>();
        // ���������Ϊ�գ���ֱ�ӷ��ؽ���б�
        if (root == null) {
            return list;
        }
        // �����ڵ���������
        TreeNode temp = root;
        queue.offer(temp);
        // ��ʼ BFS ����������
        while (!queue.isEmpty()) {
            // ��ȡ��ǰ��Ľڵ���
            int size = queue.size();
            // ��ʼ���洢��ǰ�����ֵ���б�
            List<Integer> maxList = new ArrayList<>();
            // ������ǰ������нڵ�
            while (size-- > 0) {
                // ������ǰ���һ���ڵ�
                temp = queue.poll();
                // ���ýڵ��ֵ���뵱ǰ������ֵ�б���
                maxList.add(temp.val);
                // ����ýڵ������ӽڵ㣬�����ӽڵ���������
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // ����ýڵ������ӽڵ㣬�����ӽڵ���������
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // ��ȡ��ǰ������ֵ����ӵ�����б���
            int maxNum = Collections.max(maxList);
            list.add(maxNum);
        }
        // ���ؽ���б�
        return list;
    }
}