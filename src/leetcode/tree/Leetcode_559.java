package leetcode.tree;

import java.util.*;

/**
 * 559.N������������
 * ����һ�� N �������ҵ��������ȡ�
 * ��������ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�������
 * N �������밴����������л���ʾ��ÿ���ӽڵ��ɿ�ֵ�ָ�����μ�ʾ������
 */
public class Leetcode_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * ����һ���������(�������)
     * @param root
     * @return
     */
    public int maxDepthMethodOne(Node root) {
        // �жϸ��ڵ��Ƿ�Ϊ�գ���Ϊ���򷵻�0
        if (root == null) {
            return 0;
        }
        // ����һ�����У����ڱ��������Ľڵ�
        Queue<Node> queue = new LinkedList<>();
        // �����ڵ�������
        queue.offer(root);
        // ��ʼ��������Ϊ0
        int result = 0;
        // ��ʼ������
        while (!queue.isEmpty()) {
            // ��ȡ��ǰ��ڵ������
            int size = queue.size();
            // ����ǰ������нڵ�
            while (size-- > 0) {
                // �Ӷ�����ȡ��һ���ڵ�
                Node temp = queue.poll();
                // ��ȡ�ýڵ���ӽڵ��б�
                List<Node> children = temp.children;
                // ���ӽڵ���ӵ�������
                for (Node node : children) {
                    queue.offer(node);
                }
            }
            // ��ǰ��ڵ��Ѵ����꣬����������
            result++;
        }
        // ����������
        return result;
    }

    /**
     * ���������ݹ�(�������)
     * @param root
     * @return
     */
    public int maxDepthMethodTwo(Node root) {
        // �жϸ��ڵ��Ƿ�Ϊ�գ���Ϊ���򷵻�0
        if (root == null) {
            return 0;
        }
        // ��ȡ��ǰ�ڵ�������ӽڵ�
        List<Node> children = root.children;
        // ����һ���������洢ÿ���ӽڵ����ȣ���ʼֵΪ0
        int result = 0;
        // ����ÿ���ӽڵ�
        for (Node node : children) {
            // �ݹ����maxDepthMethodTwo�����������ӽڵ�����
            int temp = maxDepthMethodTwo(node);
            // ȡ�����ӽڵ����������һ����Ϊ��ǰ�ڵ�����
            result = Math.max(result, temp);
        }
        // ���ص�ǰ�ڵ����ȣ���ǰ�ڵ����ȵ��������ӽڵ����ȼ�1��
        return 1 + result;
    }
}
