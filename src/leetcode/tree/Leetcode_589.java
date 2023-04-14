package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 589.N������ǰ�����
 * ����һ�� n �����ĸ��ڵ�  root ������ ��ڵ�ֵ�� ǰ����� ��
 * n ���� �������а���������������л���ʾ��ÿ���ӽڵ��ɿ�ֵ null �ָ�����μ�ʾ������
 */
public class Leetcode_589 {
    // ����һ�����������ڶ�N��������ǰ������������ر�������б�
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        // ���õݹ鷽��ʵ��ǰ��������������������ӵ��б���
        pre(root, list);
        return list;
    }

    // ����һ���ݹ鷽��������ʵ��ǰ�����
    private void pre(Node temp, List<Integer> list) {
        // �����ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
        if (temp == null) {
            return;
        }
        // ����ǰ�ڵ��ֵ��ӵ��б���
        list.add(temp.val);
        // ������ǰ�ڵ�������ӽڵ�
        for (Node node : temp.children) {
            // ��ÿ���ӽڵ�ݹ����pre������ʵ��ǰ�����
            pre(node, list);
        }
    }

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
}


