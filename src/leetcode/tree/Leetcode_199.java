package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199.������������ͼ
 * ����һ���������ĸ��ڵ�root�������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
 */
public class Leetcode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();  // ��Ž�����б�
        Queue<TreeNode> queue = new LinkedList<>();  // ������������Ķ���
        if (root == null) {  // ������ڵ�Ϊ�գ�ֱ�ӷ��ؿ��б�
            return list;
        }
        queue.offer(root);  // �����ڵ�������
        while (!queue.isEmpty()) {  // ֻҪ���в�Ϊ�գ��ͼ�������
            int size = queue.size();  // ��ǰ��Ľڵ�����
            int right = size;  // ��¼��ǰ�����Ҳ�Ľڵ�λ��
            int count = 1;  // ��¼��ǰ�ڵ��λ�ã�����������
            while (size-- > 0) {  // ������ǰ������нڵ�
                TreeNode temp = queue.poll();  // ȡ�����׽ڵ�
                if (count == right) {  // �����ǰ�ڵ��ǵ�ǰ�����Ҳ�Ľڵ�
                    list.add(temp.val);  // ����ǰ�ڵ��ֵ�������б�
                }
                if (temp.left != null) {  // �����ǰ�ڵ������ӽڵ㣬�������
                    queue.offer(temp.left);
                }
                if (temp.right != null) {  // �����ǰ�ڵ������ӽڵ㣬�������
                    queue.offer(temp.right);
                }
                count++;  // ��ǰ�ڵ�λ�ü�1
            }
        }
        return list;  // ���ؽ���б�
    }
}
