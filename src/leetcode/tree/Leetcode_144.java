package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144.��������ǰ�����
 * ����������ĸ��ڵ� root ���������ڵ�ֵ�� ǰ�� ������
 */
public class Leetcode_144 {

    /**
     * ����һ���ݹ�
     * �Ը����Ķ�����ִ����������������ر��������
     *
     * @param root �����Ķ��������ڵ�
     * @return ����������
     */
    public List<Integer> preorderTraversalMethodOne(TreeNode root) {
        // ����һ��ArrayList�������ڴ�ű������
        List<Integer> list = new ArrayList<>();
        // ����preOrder������ִ���������
        preOrder(root, list);
        // ���ر������
        return list;
    }

    /**
     * �ݹ�������������������������ڸ�����List�����С�
     *
     * @param temp ��ǰ�������Ľڵ�
     * @param list ���ڴ�ű��������List����
     */
    public void preOrder(TreeNode temp, List<Integer> list) {
        // �����ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
        if (temp == null) {
            return;
        }
        // ����ǰ�ڵ��ֵ����List������
        list.add(temp.val);
        // �ݹ������ǰ�ڵ��������
        preOrder(temp.left, list);
        // �ݹ������ǰ�ڵ��������
        preOrder(temp.right, list);
    }

    /**
     * ������������
     * @param root ���ڵ�
     * @return list ���ڴ�ű��������List����
     */
    public List<Integer> preorderTraversalMethodTwo(TreeNode root) {
        // ����һ��ArrayList�������ڴ�ű������
        List<Integer> list = new ArrayList<>();
        // ����һ��ջ�������ڸ���ʵ�ֱ���
        Stack<TreeNode> stack = new Stack<>();
        // ���������Ϊ�գ�ֱ�ӷ��ؿ��б�
        if (root == null) {
            return list;
        }
        // ���������ĸ��ڵ�ѹ��ջ��
        stack.push(root);
        // ѭ������ջ�еĽڵ�
        while (!stack.isEmpty()) {
            // ȡ��ջ���ڵ㣬������ֵ����List������
            TreeNode node = stack.pop();
            list.add(node.val);
            // ����ýڵ���������������������ѹ��ջ��
            if (node.right != null) {
                stack.push(node.right);
            }
            // ����ýڵ���������������������ѹ��ջ��
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        // ���ر������
        return list;
    }
}
