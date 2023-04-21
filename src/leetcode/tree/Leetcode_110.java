package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 110.ƽ�������
 * ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
 * һ��������ÿ�� �ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ��
 */
public class Leetcode_110 {
    /**
     * �ݹ��ж϶������Ƿ���ƽ�������
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // ������ڵ�Ϊ null����ô����ƽ���
        if (root == null) {
            return true;
        }
        // �����߼����ж��Ե�ǰ�ڵ���Ϊ���ڵ�Ķ������Ƿ���ƽ�������
        // ��ȡ���������������ĸ߶�
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // ������������������߶Ȳ����1����ô����ƽ�⣬���� false
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }
        // �ݹ��鵱ǰ�ڵ�����������������Ƿ�ƽ�⣬�����ƽ����������ƽ��
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * ���������߶�
     *
     * @param temp
     * @return
     */
    public int getHeight(TreeNode temp) {
        // �����ǰ�ڵ�Ϊ null����ô�߶�Ϊ0
        if (temp == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // ����ǰ�ڵ�������
        queue.offer(temp);
        // �����в�Ϊ��ʱ��˵�����нڵ�δ������������
        while (!queue.isEmpty()) {
            // ��ȡ��ǰ��ڵ�����
            int size = queue.size();
            // ������ǰ��ڵ�
            while (size-- > 0) {
                temp = queue.poll();
                // ��������ӽڵ㣬�����ӽڵ�������
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // ��������ӽڵ㣬�����ӽڵ�������
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // ������һ��ڵ㣬�߶ȼ�1
            height++;
        }
        // �����������ĸ߶�
        return height;
    }
}
