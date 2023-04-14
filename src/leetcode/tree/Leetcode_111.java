package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111.����������С���
 * ����һ�����������ҳ�����С��ȡ�
 * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
 * ˵����Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 */
public class Leetcode_111 {
    public int minDepth(TreeNode root) {
        int result = 0; // ��¼����������С���
        Queue<TreeNode> queue = new LinkedList<>(); // ��������
        if (root == null) { // ������ڵ�Ϊ�գ��������0
            return 0;
        }
        TreeNode temp = root; // ��¼��ǰ�ڵ�
        queue.offer(temp); // �����ڵ����
        while (!queue.isEmpty()) { // ѭ����������
            int size = queue.size(); // ��ȡ��ǰ���еĳ���
            while (size-- > 0) { // ������ǰ�����е����нڵ�
                temp = queue.poll(); // ��ȡ����ͷ���Ľڵ�
                if (temp.left != null) { // ����ýڵ������ӽڵ㣬����������
                    queue.offer(temp.left);
                }
                if (temp.right != null) { // ����ýڵ������ӽڵ㣬����������
                    queue.offer(temp.right);
                }
                if (temp.left == null && temp.right == null) { // ����ýڵ���Ҷ�ڵ㣬�˳�ѭ��
                    break;
                }
            }
            result++; // ������ȼ�����
            if (temp.left == null && temp.right == null) { // ������һ���ڵ���Ҷ�ڵ㣬�˳�ѭ��
                break;
            }
        }
        return result; // ������С���
    }
}
