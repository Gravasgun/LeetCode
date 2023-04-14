package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 226.��ת������
 * ����һ�ö������ĸ��ڵ�root ����ת��ö�����������������ڵ㡣
 */
public class Leetcode_226 {
    /**
     * ����һ���ݹ�
     * ʹ��ǰ����ߺ���������
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeMethodOne(TreeNode root) {
        // ������ڵ�Ϊ�գ���ֱ�ӷ���null
        if (root == null) {
            return null;
        }
        // ������ڵ�
        TreeNode result = root;
        // ���������ӽڵ�
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // �ݹ鷭ת��������������
        invertTreeMethodOne(root.left);
        invertTreeMethodOne(root.right);
        // ���ظ��ڵ�
        return result;
    }

    /**
     * �������������������
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeMethodTwo(TreeNode root) {
        // ����һ�����У����ڹ����������
        Queue<TreeNode> queue = new LinkedList<>();
        // ������ڵ�Ϊ�գ�ֱ�ӷ���null
        if (root == null) {
            return null;
        }
        // �����ڵ�������
        TreeNode temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            // ��ȡ��ǰ���еĳ��ȣ�����ǰ��Ľڵ���
            int size = queue.size();
            // ������ǰ������нڵ�
            while (size-- > 0) {
                // ȡ�����׽ڵ�
                temp = queue.poll();
                // ������ǰ�ڵ�������ӽڵ�
                TreeNode current = temp.left;
                temp.left = temp.right;
                temp.right = current;
                // ������ӽڵ㲻Ϊ�գ�����������
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // ������ӽڵ㲻Ϊ�գ�����������
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        // ���ط�ת������ĸ��ڵ�
        return root;
    }

    /**
     * ��������������
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeMethodThree(TreeNode root) {
        // ������ڵ�Ϊ�գ�ֱ�ӷ���null
        if (root == null) {
            return null;
        }
        // ����һ��ջ�����ڴ洢�������Ľڵ�
        Stack<TreeNode> stack = new Stack<>();
        // �����ڵ����ջ
        TreeNode temp = root;
        stack.push(temp);
        while (!stack.isEmpty()) {
            // ȡ��ջ���ڵ�
            temp = stack.pop();
            // ������ǰ�ڵ�������ӽڵ�
            TreeNode current = temp.left;
            temp.left = temp.right;
            temp.right = current;
            // ������ӽڵ㲻Ϊ�գ��������ջ
            if (temp.right != null) {
                stack.push(temp.right);
            }
            // ������ӽڵ㲻Ϊ�գ��������ջ
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        // ���ط�ת������ĸ��ڵ�
        return root;
    }
}