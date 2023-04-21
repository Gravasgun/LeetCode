package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 222.��ȫ�������Ľڵ����
 * ����һ����ȫ�������ĸ��ڵ�root����������Ľڵ������
 * ��ȫ�������Ķ������£�����ȫ�������У�������ײ�ڵ����û�����⣬����ÿ��ڵ������ﵽ���ֵ������������һ��Ľڵ㶼�����ڸò�����ߵ�����λ�á�����ײ�Ϊ�� h �㣬��ò����1~ 2h���ڵ㡣
 */
public class Leetcode_222 {
    public int countNodes(TreeNode root) {
        // 1. ������ڵ�Ϊ�գ�ֱ�ӷ���0��
        if (root == null) {
            return 0;
        }
        int result = 0; // �����������ڼ�¼�ڵ�����
        Queue<TreeNode> queue = new LinkedList<>(); // ��ʼ��һ�����У����ڲ������������
        TreeNode temp = root; // ����һ����ʱ�ڵ㣬��ʼֵΪ���ڵ�
        queue.offer(temp); // �����ڵ����
        while (!queue.isEmpty()) { // �����в�Ϊ��ʱ��ѭ��ִ�����²�����
            int size = queue.size(); // ��ȡ�����еĽڵ�������Ϊsize��
            List<TreeNode> list = new ArrayList<>(); // ��ʼ��һ���б����ڴ洢��ǰ������нڵ㡣
            while (size-- > 0) { // ѭ��size�Σ�ÿ�δӶ�����ȡ��һ���ڵ�
                temp = queue.poll(); // ȡ����ͷ�ڵ�
                list.add(temp); // ���ڵ���뵽�б���
                if (temp.left != null) { // ����ڵ������ӽڵ㣬������뵽������
                    queue.offer(temp.left);
                }
                if (temp.right != null) { // ����ڵ������ӽڵ㣬������뵽������
                    queue.offer(temp.right);
                }
            }
            result += list.size(); // ����ǰ��Ľڵ����ӵ���������
        }
        return result; // ���ؽڵ�����
    }
}
