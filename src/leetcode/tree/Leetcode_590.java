package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590.N�����ĺ������
 * ����һ��n�����ĸ��ڵ�root��������ڵ�ֵ�ĺ������ ��
 * n�����������а���������������л���ʾ��ÿ���ӽڵ��ɿ�ֵnull�ָ�����μ�ʾ������
 */
public class Leetcode_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>(); // ����һ�����б����ڴ洢�������
        post(root, list); // ����˽�еĵݹ鷽�����������к������
        return list; // ���ر�������б�
    }

    private void post(Node temp, List<Integer> list) {
        if (temp == null) { // ����ڵ�Ϊ�գ�ֱ�ӷ���
            return;
        }
        for (Node node : temp.children) { // ������ǰ�ڵ�������ӽڵ�
            post(node, list); // �ݹ�����ӽڵ�
        }
        list.add(temp.val); // ����ǰ�ڵ��ֵ��ӵ���������б���
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
