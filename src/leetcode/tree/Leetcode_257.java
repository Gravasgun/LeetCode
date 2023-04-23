package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257.������������·��
 * ����һ���������ĸ��ڵ�root��������˳�� ���������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 */
public class Leetcode_257 {
    /**
     * ����һ������
     * @param root
     * @return
     */
    public List<String> binaryTreePathsMethodOne(TreeNode root) {
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

    /**
     * ���������ݹ�
     * @param root
     * @return
     */
    public List<String> binaryTreePathsMethodTwo(TreeNode root) {
        List<String> result = new ArrayList<>(); // ���ڴ洢������б�
        if (root == null) {
            return result; // ������ڵ�Ϊ�գ�ֱ�ӷ��ؽ���б�
        }
        List<Integer> paths = new ArrayList<>(); // ���ڴ洢��ǰ·�����б�
        traversal(root, result, paths); // ��ʼ��������������������·��
        return result; // ���ؽ���б�
    }

    // �ݹ麯�������ڱ���������
    private void traversal(TreeNode temp, List<String> result, List<Integer> paths) {
        paths.add(temp.val); // ����ǰ�ڵ���ӵ�·���б���
        if (temp.left == null && temp.right == null) { // �����ǰ�ڵ���Ҷ�ӽڵ㣬˵���Ѿ���������һ��������·��
            StringBuilder sb = new StringBuilder(); // ����һ��StringBuilder����
            for (int i = 0; i < paths.size() - 1; i++) { // ����·���б������нڵ��ֵ��ӵ�StringBuilder������
                sb.append(paths.get(i)).append("->"); // ��ӽڵ�ֵ�ͼ�ͷ����"->"
            }
            sb.append(paths.get(paths.size() - 1)); // ������һ���ڵ��ֵ
            result.add(sb.toString()); // ��StringBuilder����ת��Ϊ�ַ�������ӵ�����б���
            return; // ����
        }
        if (temp.left != null) { // ������ӽڵ㲻Ϊ�գ���������������
            traversal(temp.left, result, paths);
            paths.remove(paths.size() - 1); // �Ƴ�·���б��е����һ��Ԫ�أ����ݵ���һ���ڵ�
        }
        if (temp.right != null) { // ������ӽڵ㲻Ϊ�գ���������������
            traversal(temp.right, result, paths);
            paths.remove(paths.size() - 1); // �Ƴ�·���б��е����һ��Ԫ�أ����ݵ���һ���ڵ�
        }
    }
}
