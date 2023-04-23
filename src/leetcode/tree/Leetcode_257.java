package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257.������������·��
 * ����һ���������ĸ��ڵ�root��������˳�� ���������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 */
public class Leetcode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        // ����һ���յ��б����洢���
        List<String> result = new ArrayList<>();
        // ������ڵ�Ϊ�գ�ֱ�ӷ��ؽ���б�
        if (root == null) {
            return result;
        }
        // ����һ��ջ���ڱ���������Ľڵ��·����Ϣ
        Stack<Object> stack = new Stack<>();
        // �����ڵ�͸��ڵ�ֵ���ַ�����ʽѹ��ջ��
        stack.push(root);
        stack.push(root.val + "");
        // ��ջ�ǿ�ʱ����ѭ��
        while (!stack.isEmpty()) {
            // ��ջ������һ��·��
            String path = (String) stack.pop();
            // ��ջ������һ���ڵ�
            TreeNode node = (TreeNode) stack.pop();
            // ����ýڵ���Ҷ�ӽڵ㣬��·���������б�
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            // ����ýڵ������ӽڵ㣬�����ӽڵ��·����Ϣѹ��ջ��
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            // ����ýڵ������ӽڵ㣬�����ӽڵ��·����Ϣѹ��ջ��
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        // ���ؽ���б�
        return result;
    }
}
