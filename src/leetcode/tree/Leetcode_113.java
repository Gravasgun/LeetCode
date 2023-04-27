package leetcode.tree;

import java.util.*;

/**
 * 113.·���ܺ�II
 * ����������ĸ��ڵ� root ��һ������Ŀ��� targetSum ���ҳ����� �Ӹ��ڵ㵽Ҷ�ӽڵ� ·���ܺ͵��ڸ���Ŀ��͵�·����
 */
public class Leetcode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>(); // ���ڱ��������б�
        if (root == null) { // ���У�������ڵ�Ϊ�գ�ֱ�ӷ��ؿ��б�
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>(); // ���ڱ��������ڵ��ջ
        Stack<List<Integer>> pathStack = new Stack<>(); // ���ڱ��浱ǰ�ڵ㵽���ڵ��·����ջ
        nodeStack.push(root); // �����ڵ���ջ
        pathStack.push(Arrays.asList(root.val)); // ���ڵ��·��Ϊ�䱾��������ջ
        while (!nodeStack.isEmpty()) { // ѭ��ֱ��������ڵ�ջΪ��
            TreeNode temp = nodeStack.pop(); // ȡ��������ڵ�ջ��ջ���ڵ�
            List<Integer> path = pathStack.pop(); // ȡ��·��ջ��ջ��·��
            if (temp.left == null && temp.right == null && targetSum == path.stream().mapToInt(Integer::intValue).sum()) {
                // ���ջ���ڵ���Ҷ�ӽڵ㣬���Ҹ��ڵ㵽��Ҷ�ӽڵ��·���͵���Ŀ��ͣ�����·����ӵ�����б���
                result.add(path);
            }
            if (temp.right != null) { // ���ջ���ڵ�����ӽڵ㲻Ϊ��
                nodeStack.push(temp.right); // �����ӽڵ���ջ
                List<Integer> rightPath = new ArrayList<>(path); // ���ýڵ㵽���ڵ��·������һ��
                rightPath.add(temp.right.val); // �����ӽڵ��ֵ��ӵ��ýڵ㵽���ڵ��·����
                pathStack.push(rightPath); // ���ýڵ㵽���ڵ��·����ջ
            }
            if (temp.left != null) { // ���ջ���ڵ�����ӽڵ㲻Ϊ�գ�ִ�к����ӽڵ�ͬ���Ĳ���
                nodeStack.push(temp.left);
                List<Integer> leftPath = new ArrayList<>(path);
                leftPath.add(temp.left.val);
                pathStack.push(leftPath);
            }
        }
        return result; // ���ؽ���б�
    }
}
