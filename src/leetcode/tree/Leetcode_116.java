package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 116.���ÿ���ڵ����һ���Ҳ�ڵ�ָ��
 * ����һ��������������������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣
 * �������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
 * ��ʼ״̬�£����� next ָ�붼������Ϊ NULL��
 */
public class Leetcode_116 {
    public Node connect(Node root) {
        // ����һ�����У����ڲ������
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        // �����ڵ����
        Node temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            // ������ǰ������нڵ�
            while (size-- > 0) {
                temp = queue.poll();
                list.add(temp);
                // ��������ӣ����������
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // ������Һ��ӣ����Һ������
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // ����ǰ��Ľڵ��nextָ��ָ����һ���ڵ�
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    // �����ǰ�ڵ��Ǹò����һ���ڵ㣬����nextָ��ָ��null
                    list.get(i).next = null;
                } else {
                    // ���򣬽���ǰ�ڵ��nextָ��ָ����һ���ڵ�
                    list.get(i).next = list.get(i + 1);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}