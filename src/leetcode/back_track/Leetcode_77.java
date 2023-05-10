package leetcode.back_track;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.���
 * ������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ�
 * ����԰� �κ�˳�� ���ش𰸡�
 */
public class Leetcode_77 {
    // �洢��Ͻ�����б�
    // ������������ȫ�ֱ���Ҳ�ǿ��Եģ��������������Ž��ݹ麯���Ĳ���������������̫��Ӱ��ɶ��ԣ����Զ���ȫ�ֱ���
    List<List<Integer>> result = new ArrayList<>();
    // ��ǰ�������ɵ����·��
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        // ������ϸ������������������
        combineHelper(n, k, 1);
        // �������յ���Ͻ��
        return result;
    }

    // ��ϸ�������
    private void combineHelper(int n, int k, int startIndex) {
        // �����ǰ·�����ȵ��� k����ʾ�Ѿ�������һ�����
        if (path.size() == k) {
            // ����ǰ·����ӵ�����б���
            result.add(new ArrayList<>(path));
            return;
        }

        /**
         * �� startIndex �� n-(k-path.size())+1 ����ѭ������֤ʣ��������㹻�������
         * ��֦�ĵط��ڵݹ���ÿһ���forѭ����ѡ�����ʼλ��
         * ���forѭ��ѡ�����ʼλ��֮���Ԫ�ظ��� �Ѿ����� ������Ҫ��Ԫ�ظ����ˣ���ô��û�б�Ҫ������
         *
         * �Ƶ����̣�
         * startIndex����ʾ��ǰѭ������ʼλ�á�
         * n����ʾ�ܹ���ѡ������ַ�Χ������ 1 �� n��
         * k����ʾ�����Ҫѡ�������������
         * path.size()����ʾ�Ѿ�ѡ�������������
         *
         * �������ǻ���Ҫѡ�� k - path.size() �����֣���ѭ������ֹ������ i <= n������������Ҫ�ҵ�ѭ�������Χ��
         *
         * �����Ѿ�ѡ���� path.size() �����֣���ѭ����ֹʱ���ǻ���Ҫѡ������ k - path.size() ������
         * ����ѭ�������ΧӦΪ n - (k - path.size()) + 1��
         */
        // for (int i = startIndex; i <= n; i++) {
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            // ����ǰ������ӵ�·����
            path.add(i);
            // �ݹ�������һ�����ֵ����
            combineHelper(n, k, i + 1);
            // ���ݣ�����ǰ���ִ�·�����Ƴ���������һ������
            path.remove(path.size() - 1);
        }
    }
}