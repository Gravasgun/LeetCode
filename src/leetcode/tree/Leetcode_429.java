package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429.N�����Ĳ������
 * ����һ��N������������ڵ�ֵ�Ĳ�����������������ң�����������
 * �������л��������ò��������ÿ���ӽڵ㶼�� null ֵ�ָ����μ�ʾ������
 */
public class Leetcode_429 {
    // �������ڵ���
    class Node {
        public int val; // �ڵ��ֵ
        public List<Node> children; // �ӽڵ��б�

        public Node() {
        } // �޲ι��캯��

        public Node(int val) { // ��ֵ�����Ĺ��캯��
            this.val = val;
        }

        public Node(int val, List<Node> children) { // ��ֵ���ӽڵ��б�����Ĺ��캯��
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) { // ��������������
        List<List<Integer>> result = new ArrayList<>(); // ���ڴ洢������б�
        Queue<Node> queue = new LinkedList<>(); // ������У����ڴ洢�������Ľڵ�
        if (root == null) { // ������ڵ�Ϊ�գ��򷵻ؿ��б�
            return result;
        }
        queue.offer(root); // �����ڵ�������
        Node temp = root; // ����һ����ʱ�ڵ㣬���ڴ洢ÿ�δӶ�����ȡ���Ľڵ�
        while (!queue.isEmpty()) { // ֻҪ���в�Ϊ�գ��ͼ�������
            int size = queue.size(); // ��¼��ǰ���еĴ�С
            List<Integer> list = new ArrayList<>(); // �����б����ڴ洢��ǰ��Ľڵ�ֵ
            while (size-- > 0) { // ������ǰ������нڵ�
                temp = queue.poll(); // ȡ������ͷ���Ľڵ㣬�����丳ֵ����ʱ�ڵ�
                list.add(temp.val); // ����ʱ�ڵ��ֵ�����б���
                List<Node> children = temp.children; // ��ȡ��ʱ�ڵ���ӽڵ��б�
                if (!children.isEmpty()) { // ����ӽڵ��б�Ϊ��
                    for (int i = 0; i < children.size(); i++) { // ���������ӽڵ�
                        queue.offer(children.get(i)); // ���ӽڵ�������
                    }
                }
            }
            result.add(list); // ����ǰ��Ľڵ�ֵ�б�������б���
        }
        return result; // ���ؽ���б�
    }
}
