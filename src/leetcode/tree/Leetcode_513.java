package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_513 {
    /**
     * 513.�������½ǵ�ֵ
     * ����һ���������ĸ��ڵ� root�����ҳ��ö������� ��ײ� ����� �ڵ��ֵ��
     * �����������������һ���ڵ㡣
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        // �����ڵ��Ƿ�Ϊnull
        if (root == null) {
            return -1;
        }
        // ����һ���б����洢��������ÿһ��������ֵ
        List<Integer> list = new ArrayList<>();
        // ����һ���������洢�������Ľڵ�
        Queue<TreeNode> queue = new LinkedList<>();
        // �����ڵ���ӵ�������
        TreeNode temp = root;
        queue.offer(temp);
        // �����в�Ϊ��ʱ����������
        while (!queue.isEmpty()) {
            // ��ȡ���еĴ�С
            int size = queue.size();
            // ���ر����������жϵ�ǰ�ڵ��Ƿ�Ϊÿһ������ߵĽڵ�
            boolean on = true;
            while (size-- > 0) {
                // ȡ�������е�ͷ�ڵ�
                temp = queue.poll();
                // �����ǰ�ڵ��Ǹò��һ�������ʵĽڵ㣬����ֵ�����б��У��������ر�������Ϊfalse
                if (on) {
                    list.add(temp.val);
                    on = false;
                }
                // ����ýڵ����ڵ㲻Ϊnull��������������
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // ����ýڵ���ҽڵ㲻Ϊnull��������������
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        // �����б������һ��ֵ��������������ײ����ߵĽڵ��ֵ
        return list.get(list.size() - 1);
    }
}
