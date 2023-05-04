package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 530.��������������С���Բ�
 * ����һ�������������ĸ��ڵ� root ������ ������������ͬ�ڵ�ֵ֮�����С��ֵ��
 * ��ֵ��һ������������ֵ������ֵ֮��ľ���ֵ��
 */
public class Leetcode_530 {
    /**
     * ����һ�������ⷨ
     *
     * @param root
     * @return
     */
    public int getMinimumDifferenceMethodOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();   // ����һ���洢�������ڵ�ֵ���б�
        List<Integer> nums = preOrder(root, list);  // ���� preOrder ����������������������ڵ�ֵ�洢���б���
        Collections.sort(nums);  // ���ڵ�ֵ�б�����
        int minNum = Integer.MAX_VALUE;  // ����һ�����������洢��С��ֵ����ʼ��Ϊ�������ֵ
        for (int i = 0; i < nums.size() - 1; i++) {  // ���������Ľڵ�ֵ�б�
            if (Math.abs(nums.get(i) - nums.get(i + 1)) < minNum) {  // �������ڽڵ�ֵ֮��Ĳ�ֵ�����ж��Ƿ�С�ڵ�ǰ��С��ֵ
                minNum = Math.abs(nums.get(i) - nums.get(i + 1));  // ������С��ֵ
            }
        }
        return minNum;  // ������С��ֵ
    }

    private List<Integer> preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {  // ���������Ϊ�գ�ֱ�ӷ����б�
            return list;
        }
        list.add(root.val);  // ����ǰ�ڵ�ֵ�����б���
        preOrder(root.left, list);  // �ݹ����������
        preOrder(root.right, list);  // �ݹ����������
        return list;  // ���ش洢�ڵ�ֵ���б�
    }


    /**
     * ���������ݹ�
     *
     * @param root
     * @return
     */
    // pre �洢��ǰ�����ڵ��ǰһ���ڵ㣬result �洢��С��ֵ�ĳ�ʼֵΪ�������
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    // �ҵ����������������������ڵ�֮�����С��ֵ
    public int getMinimumDifferenceMethodTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // ���������������������ҵ���С��ֵ
        traversal(root);
        // ������С��ֵ
        return result;
    }

    // �ݹ��������������
    private void traversal(TreeNode temp) {
        if (temp == null) {
            return;
        }
        // �ȱ���������
        traversal(temp.left);
        // ��� pre ��Ϊ�գ������ result�����Ƚϵ�ǰ�ڵ��ǰһ���ڵ�֮��Ĳ�ֵ�Ƿ��С
        if (pre != null) {
            result = Math.min(result, temp.val - pre.val);
        }
        // ���� pre Ϊ��ǰ�ڵ㣬��������������
        pre = temp;
        traversal(temp.right);
    }
}
