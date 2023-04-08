package leetcode.tree;

import java.util.*;

/**
 * 145.�������ĺ������
 * ����һ�ö������ĸ��ڵ� root ��������ڵ�ֵ�� ������� ��
 */
public class Leetcode_145 {
    /**
     * ������������������ر������
     *
     * @param root �������ĸ��ڵ�
     * @return �������
     */
    public List<Integer> postorderTraversalMethodOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list); // ���ú����������
        return list; // ���ر������
    }

    /**
     * ����һ���ݹ�
     * ������������������������������ list ��
     *
     * @param temp ��ǰ�ڵ�
     * @param list �洢����������б�
     */
    public void postOrder(TreeNode temp, List<Integer> list) {
        if (temp == null) { // �����ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
            return;
        }
        postOrder(temp.left, list); // �ݹ����������
        postOrder(temp.right, list); // �ݹ����������
        list.add(temp.val); // ����ǰ�ڵ��ֵ��ӵ����������
    }

    /**
     * ������������
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // �洢����������б�
        Stack<TreeNode> stack = new Stack<>(); // �洢�������ڵ��ջ
        if (root == null) { // ���п��������
            return list;
        }
        stack.push(root); // �����ڵ���ջ
        while (!stack.isEmpty()) { // ��ջ��Ϊ��ʱ����������
            TreeNode node = stack.pop(); // ȡ��ջ��Ԫ��
            list.add(node.val); // ��ջ��Ԫ�ص�ֵ��ӵ����������
            if (node.left != null) { // �����������Ϊ�գ�����������ջ
                stack.push(node.left);
            }
            if (node.right != null) { // �����������Ϊ�գ�����������ջ
                stack.push(node.right);
            }
        }
        Collections.reverse(list); // ��ת�������
        return list; // ���ر������
    }
}
