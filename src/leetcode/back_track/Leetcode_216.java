package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.����ܺ�III
 * �ҳ��������֮��Ϊ n �� k ��������ϣ�����������������
 * ֻʹ������1��9
 * ÿ������ ���ʹ��һ��
 * ���� ���п��ܵ���Ч��ϵ��б� �����б��ܰ�����ͬ��������Σ���Ͽ������κ�˳�򷵻ء�
 */
public class Leetcode_216 {
    List<List<Integer>> result = new ArrayList<>();  // �洢���ս�����б�
    List<Integer> paths = new ArrayList<>();  // �洢��ǰ·�����б�

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);  // ���û��ݺ���
        return result;  // ���ؽ���б�
    }

    private void backTracking(int k, int n, int startIndex) {
        if (paths.size() == k) {  // �����ǰ·�����ȵ���Ŀ�곤��
            if (paths.stream().mapToInt(Integer::intValue).sum() == n) {  // �����ǰ·���е�����֮�͵���Ŀ��ֵ
                // ��Java�У�result.add(paths)�Ὣpaths�б��������ӵ�result�У������Ǵ���һ���µ��б����
                // ����ζ����������޸���paths�б���ӵ�result�е�·��Ҳ����֮�ı䣬����ܵ��²���ȷ�Ľ����
                result.add(new ArrayList<>(paths));  // ����ǰ·����ӵ����ս���б���
            }
            return;  // ������һ��ݹ�
        }

        for (int i = startIndex; i <= 9 - (k - paths.size()) + 1; i++) {
            paths.add(i);  // ����ǰ������ӵ�·����
            backTracking(k, n, i + 1);  // �ݹ������һ��
            paths.remove(paths.size() - 1);  // �Ƴ���ǰ���֣����ݵ���һ��
        }
    }
}