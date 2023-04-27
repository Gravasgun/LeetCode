package leetcode.tree;

import java.util.Stack;

/**
 * 112.·���ܺ�
 * ����������ĸ��ڵ� root ��һ����ʾĿ��͵����� targetSum ��
 * �жϸ������Ƿ���� ���ڵ㵽Ҷ�ӽڵ� ��·��������·�������нڵ�ֵ��ӵ���Ŀ��� targetSum ��
 * ������ڣ����� true �����򣬷��� false ��
 */
public class Leetcode_112 {
    /**
     * ����һ������
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumMethodOne(TreeNode root, int targetSum) {
        if (root == null) { // ������ڵ�Ϊ�գ�ֱ�ӷ���false
            return false;
        }
        Stack<Object> stack = new Stack<>(); // ����һ��ջ����DFS
        stack.push(root); // �����ڵ�ѹ��ջ��
        stack.push(root.val); // �����ڵ��ֵҲѹ��ջ��
        while (!stack.isEmpty()) { // ��ջ��Ϊ��ʱ����ѭ��
            int value = (int) stack.pop(); // ��ջ��ȡ����ǰ�ڵ��ֵ
            TreeNode temp = (TreeNode) stack.pop(); // ��ջ��ȡ����ǰ�ڵ�
            if (temp.left == null && temp.right == null && value == targetSum) {
                // �����ǰ�ڵ�ΪҶ�ӽڵ㣬������ֵ����Ŀ��ͣ���ô�ͷ���true
                return true;
            }
            if (temp.right != null) { // �����ǰ�ڵ���������������������ѹ��ջ��
                stack.push(temp.right);
                stack.push(value + temp.right.val); // ����������ֵ���ϵ�ǰ�ڵ��ֵѹ��ջ��
            }
            if (temp.left != null) { // �����ǰ�ڵ���������������������ѹ��ջ��
                stack.push(temp.left);
                stack.push(value + temp.left.val); // ����������ֵ���ϵ�ǰ�ڵ��ֵѹ��ջ��
            }
        }
        return false; // ѭ����������Ȼû���ҵ�����������·�����򷵻�false
    }

    /**
     * ���������ݹ�
     *
     * @param root
     * @param targetsum
     * @return
     */
    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) { // ������ڵ�Ϊ�գ�ֱ�ӷ���false
            return false;
        }
        targetsum -= root.val; // ����ʣ���Ŀ���
        // ����Ѿ�����Ҷ�ӽ��
        if (root.left == null && root.right == null) {
            return targetsum == 0; // �ж�ʣ���Ŀ����Ƿ�Ϊ0������ǣ�����true�����򷵻�false
        }
        if (root.left != null) { // �����������Ϊ��
            boolean left = haspathsum(root.left, targetsum); // �ݹ����������
            if (left) { // ����ҵ��˷���������·����ֱ�ӷ���true
                return true;
            }
        }
        if (root.right != null) { // �����������Ϊ��
            boolean right = haspathsum(root.right, targetsum); // �ݹ����������
            if (right) { // ����ҵ��˷���������·����ֱ�ӷ���true
                return true;
            }
        }
        return false; // ��������������������ˣ�Ҳû���ҵ�����������·��������false
    }
}

