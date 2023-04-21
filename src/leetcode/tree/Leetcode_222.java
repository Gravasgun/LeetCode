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
    /**
     * ����һ��������ȱ���(�������)
     *
     * @param root
     * @return
     */
    public int countNodesMethodOne(TreeNode root) {
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

    /**
     * �������������������(�ݹ�)
     *
     * @param root
     * @return
     */
    public int countNodesMethodTwo(TreeNode root) {
        // ������ڵ�Ϊ�գ�ֱ�ӷ��� 0����ʾ�ڵ���Ϊ 0
        if (root == null) {
            return 0;
        }
        // �ݹ�����������ڵ���
        int leftNum = countNodesMethodTwo(root.left);
        // �ݹ�����������ڵ���
        int rightNum = countNodesMethodTwo(root.right);
        // �����������ڵ������������ڵ����͸��ڵ㣨1���ĺ�
        return leftNum + rightNum + 1;
    }

    /**
     * ��������������������������
     *
     * @param root
     * @return
     */
    public int countNodesMethodThree(TreeNode root) {
        if (root == null) {  // ������ڵ�Ϊ�գ�����0
            return 0;
        }
        TreeNode left = root.left;  // ��ȡ��ǰ�ڵ����ڵ�
        TreeNode right = root.right;  // ��ȡ��ǰ�ڵ���ҽڵ�
        int leftCount = 0;  // ���������
        int rightCount = 0;  // ���������
        while (left != null) {  // ѭ���������������
            left = left.left;
            leftCount++;
        }
        while (right != null) {  // ѭ���������������
            right = right.right;
            rightCount++;
        }
        if (leftCount == rightCount) {  // �����������������
            return (2 << leftCount) - 1;  // ��ȫ�������ڵ�����ʽ
        }
        int leftNum = countNodesMethodThree(root.left);  // �ݹ�����������ڵ���
        int rightNum = countNodesMethodThree(root.right);  // �ݹ�����������ڵ���
        return leftNum + rightNum + 1;  // �����ܽڵ���
    }

}
