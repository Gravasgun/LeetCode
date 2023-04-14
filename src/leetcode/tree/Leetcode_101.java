package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101.�Գƶ�����
 * ����һ���������ĸ��ڵ� root �� ������Ƿ���Գơ�
 */
public class Leetcode_101 {
    /**
     * ����һ�������������
     * @param root
     * @return
     */
    public boolean isSymmetricMethodOne(TreeNode root) {
        // ������ڵ�Ϊ�գ���ֱ�ӷ���true
        if (root == null) {
            return true;
        }
        // ʹ�ö���������BFS���������������
        Queue<TreeNode> queue = new LinkedList<>();
        // ���Ƚ����������ĸ��ڵ���������
        queue.offer(root.left);
        queue.offer(root.right);
        // ������в�Ϊ�գ���һֱѭ��
        while (!queue.isEmpty()) {
            // �Ӷ�����ȡ�������ڵ㣬�ֱ�������������������еĵ�ǰ�ڵ�
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // ����������ڵ㶼Ϊ�գ�����������ѭ��
            if (left == null && right == null) {
                continue;
            }
            // �������һ���ڵ�Ϊ�գ��򷵻�false
            if (left == null || right == null) {
                return false;
            }
            // ����������ڵ��ֵ����ȣ��򷵻�false
            if (left.val != right.val) {
                return false;
            }
            // �������������ӽڵ�������������ӽڵ㣬�Լ������������ӽڵ�������������ӽڵ����μ��������
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        // �����ѭ����û�з���false����ô���ǶԳƶ�����
        return true;
    }

    /**
     * ���������ݹ�(�����������)
     * @param root
     * @return
     */
    public boolean isSymmetricMethodTwo(TreeNode root) {
        // ���õݹ麯�����Ƚ����������Ƿ�Գ�
        return compare(root.left, root.right);
    }

    /**
     * �ݹ鷽��
     * @param left
     * @param right
     * @return
     */
    private boolean compare(TreeNode left, TreeNode right) {
        // ������ӽڵ�Ϊ�գ����ӽڵ�ǿգ��򲻶Գ�
        if (left == null && right != null) {
            return false;
        }
        // ������ӽڵ�ǿգ����ӽڵ�Ϊ�գ��򲻶Գ�
        if (left != null && right == null) {
            return false;
        }
        // ��������ӽڵ��Ϊ�գ���Գ�
        if (left == null && right == null) {
            return true;
        }
        // ��������ӽڵ��ֵ����ȣ��򲻶Գ�
        if (left.val != right.val) {
            return false;
        }
        // �Ƚ����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ㣬�Լ����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ��Ƿ�Գ�
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        // ��������������Գƣ����������Գ�
        return outside && inside;
    }
}