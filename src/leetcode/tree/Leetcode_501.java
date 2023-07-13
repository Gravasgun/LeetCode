package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode_501 {
    /**
     * ���Ҷ����������г��ִ������Ľڵ�ֵ
     *
     * @param root �����������ĸ��ڵ�
     * @return ���ִ������Ľڵ�ֵ��ɵ�����
     */
    public int[] findMode(TreeNode root) {
        // ���ڴ洢�ڵ�ֵ������ִ�����ӳ���ϵ
        Map<Integer, Integer> map = new HashMap<>();
        // �������������������ͳ�ƽڵ�ֵ�ĳ��ִ���
        preorder(root, map);
        // ��ӳ���ϵ���ճ��ִ����������򣬲�ת��Ϊ�б�
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue() - c1.getValue())
                .collect(Collectors.toList());
        // ���ڴ洢���ִ������Ľڵ�ֵ
        List<Integer> result = new ArrayList<>();
        // �����ִ������Ľڵ�ֵ��ӵ�����б���
        result.add(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            // �����ǰ�ڵ�ֵ�ĳ��ִ�����ǰһ���ڵ�ֵ�ĳ��ִ�����ȣ��򽫸ýڵ�ֵ��ӵ�����б���
            if (list.get(i - 1).getValue() == list.get(i).getValue()) {
                result.add(list.get(i).getKey());
            } else {
                // ��������ѭ��
                break;
            }
        }
        // ������б�ת��Ϊ���鲢����
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * �������������������ͳ�ƽڵ�ֵ�ĳ��ִ���
     *
     * @param root �����������ĸ��ڵ�
     * @param map  ���ڴ洢�ڵ�ֵ������ִ�����ӳ���ϵ
     */
    private void preorder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        // ͳ�ƽڵ�ֵ�ĳ��ִ���
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        // �ݹ鴦��������
        preorder(root.left, map);
        // �ݹ鴦��������
        preorder(root.right, map);
    }
}