package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.��������������
 * ����һ�����������ҳ��������ȡ�
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 */
public class Leetcode_104 {
    /**
     * ����һ��������ȱ������������
     * @param root
     * @return
     */
    public int maxDepthMethodOne(TreeNode root) {
        int result = 0; // ��ʼ�����Ϊ0
        Queue<TreeNode> queue = new LinkedList<>(); // ����һ���������ڱ�����
        if (root == null) { // ���У�������ڵ�Ϊ�գ�ֱ�ӷ���0
            return 0;
        }
        TreeNode temp = root; // ��һ������temp�����浱ǰ�ڵ�
        queue.offer(temp); // �����ڵ����
        while (!queue.isEmpty()) { // ֻҪ���в�Ϊ�գ���һֱѭ��
            int size = queue.size(); // ��ȡ��ǰ������Ԫ�صĸ���
            while (size-- > 0) { // ����ÿ��Ԫ�أ�һ�γ��ӣ��ٰ����������ӽڵ����
                temp = queue.poll(); // ����һ��Ԫ��
                if (temp.left != null) { // ����ýڵ������ӽڵ㣬�������
                    queue.offer(temp.left);
                }
                if (temp.right != null) { // ����ýڵ������ӽڵ㣬�������
                    queue.offer(temp.right);
                }
            }
            result++; // ÿ��ѭ����������ȼ�1
        }
        return result; // ��󷵻����
    }

    /**
     * ��������������ȱ������ݹ�
     * @param root
     * @return
     */
    public int maxDepthMethodTwo(TreeNode root) {
        return maxHeight(root); // ���ض�������������
    }

    // �����������ÿ���ڵ�ĸ߶ȣ������ض����������߶�
    private int maxHeight(TreeNode temp) {
        if (temp == null) { // �����ǰ�ڵ�Ϊnull���򷵻�0���ݹ���ֹ����
            return 0;
        }
        int leftHeight = maxHeight(temp.left); // �����������ĸ߶�
        int rightHeight = maxHeight(temp.right); // �����������ĸ߶�
        int height = 1 + Math.max(leftHeight, rightHeight); // ��ǰ�ڵ�ĸ߶�Ϊ���������и���ĸ߶��ټ���1
        return height; // ���ص�ǰ�ڵ�ĸ߶�
    }
}
