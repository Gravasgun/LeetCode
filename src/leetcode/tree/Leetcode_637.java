package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637.�������Ĳ�ƽ��ֵ
 * ����һ���ǿն������ĸ��ڵ� root�����������ʽ����ÿһ��ڵ��ƽ��ֵ��
 */
public class Leetcode_637 {

    /**
     * ���������ÿһ��Ľڵ�ƽ��ֵ
     *
     * @param root �������ĸ��ڵ�
     * @return ÿһ��ڵ��ƽ��ֵ�б�
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // ��������б�
        List<Double> list = new ArrayList<>();
        // �����������ڹ����������
        Queue<TreeNode> queue = new LinkedList<>();
        // ������ڵ�Ϊ�գ���ֱ�ӷ��ؿ��б�
        if (root == null) {
            return list;
        }
        // �����ڵ�������
        queue.offer(root);
        // ��ʼ����ǰ�ڵ�Ϊ���ڵ�
        TreeNode temp = root;
        // ��������������
        while (!queue.isEmpty()) {
            // ��¼��ǰ��ڵ�ĸ���
            int size = queue.size();
            // �����洢��ǰ��ڵ�ֵ���б�
            List<Double> averageList = new ArrayList<>();
            // ����ǰ������нڵ�
            while (size-- > 0) {
                // ���������еĽڵ�
                temp = queue.poll();
                // ���ڵ��ֵ��ӵ���ǰ���б���
                averageList.add((double) temp.val);
                // �����ӽڵ�������
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // �����ӽڵ�������
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // ���㵱ǰ��ڵ�ֵ��ƽ��ֵ
            double average = average(averageList);
            // ��ƽ��ֵ��ӵ�����б���
            list.add(average);
        }
        // ���ؽ���б�
        return list;
    }

    /**
     * �����б�����������ƽ��ֵ
     *
     * @param averageList �洢��ֵ���б�
     * @return ƽ��ֵ
     */
    private double average(List<Double> averageList) {
        // ��ʼ��ƽ��ֵΪ0
        double average = 0;
        // �����б��е�������
        for (int i = 0; i < averageList.size(); i++) {
            // ��������������
            average += averageList.get(i);
        }
        // ����ƽ��ֵ
        average = average / averageList.size();
        // ����ƽ��ֵ
        return average;
    }
}
