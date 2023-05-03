package leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 501.�����������е�����
 * ����һ�����ظ�ֵ�Ķ�����������BST���ĸ��ڵ� root ���ҳ������� BST �е����� ��������������Ƶ����ߵ�Ԫ�أ���
 * ��������в�ֹһ�����������԰� ����˳�� ���ء�
 * �ٶ� BST �������¶��壺
 * ����������������ڵ��ֵ С�ڵ��� ��ǰ�ڵ��ֵ
 * ����������������ڵ��ֵ ���ڵ��� ��ǰ�ڵ��ֵ
 * �����������������Ƕ���������
 */
public class Leetcode_501 {
    public int[] findMode(TreeNode root) {
        // ����һ�� List ��Ŷ�����������������
        List<Integer> list = new ArrayList<>();
        // �Զ�������������������������������ŵ� list ��
        List<Integer> inorderList = inorder(root, list);
        // ����һ�� List ����������
        List<Integer> result = new ArrayList<>();
        // ����һ�� Map ��Ŷ������нڵ���ֵĴ���
        Map<Integer, Integer> map = new HashMap<>();
        // ����������������������ͳ��ÿ���ڵ���ֵĴ���
        for (int i : inorderList) {
            if (map.containsKey(i)) {
                Integer value = map.get(i);
                map.put(i, ++value);
            } else {
                map.put(i, 1);
            }
        }
        // �� map �еļ�ֵ�԰��ռ����ڵ��ֵ�����򣬴�ŵ� sortedMap ��
        Map<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(map);
        // �� sortedMap �еļ�ֵ�Դ�ŵ� sortedList �У�������ֵ���ڵ���ֵĴ������Ӵ�С����
        List<Map.Entry<Integer, Integer>> sortedList = sortedMap.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).collect(Collectors.toList());
        // �� sortedList �г��ִ������Ľڵ��ֵ��ŵ� result ��
        result.add(sortedList.get(0).getKey());
        // �������Ľڵ���ֵĴ����������ִ�����ͬ����Ҳ���뵽 result ��
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i).getValue() == sortedList.get(i - 1).getValue()) {
                result.add(sortedList.get(i).getKey());
            }else {
                break;
            }
        }
        // �� result ת���� int[] ���Ͳ�����
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * �������������
     * @param root �������ĸ��ڵ�
     * @param list ��ű�������� List
     * @return ���ر������
     */
    public List<Integer> inorder(TreeNode root, List list) {
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
}
