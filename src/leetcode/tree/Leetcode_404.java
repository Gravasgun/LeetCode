package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_404 {
    List<Integer> list = new ArrayList<>();
    // �����������������Ҷ�ӽڵ��ֵ�ĺ�
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // �����ǰ�ڵ�����ӽڵ������ΪҶ�ӽڵ㣬����ֵ��ӵ��б���
        if (root.left != null && root.left.left == null && root.left.right == null) {
            list.add(root.left.val);
        }
        // �ݹ鴦��������
        sumOfLeftLeaves(root.left);
        // �ݹ鴦��������
        sumOfLeftLeaves(root.right);
        // ������Ҷ�ӽڵ��ֵ�ĺͲ�����
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
