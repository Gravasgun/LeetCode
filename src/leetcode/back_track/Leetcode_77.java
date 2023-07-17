package leetcode.back_track;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_77 {
    // �洢��Ͻ�����б�
    // ������������ȫ�ֱ���Ҳ�ǿ��Եģ��������������Ž��ݹ麯���Ĳ���������������̫��Ӱ��ɶ��ԣ����Զ���ȫ�ֱ���
    List<List<Integer>> result = new ArrayList<>();
    // ��ǰ�������ɵ����·��
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        // ������ϸ������������������
        backTrack(n, k, 1);
        // �������յ���Ͻ��
        return result;
    }

    // ���ݺ���
    private void backTrack(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
