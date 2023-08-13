package kedaxunfei;

import java.util.*;
/**
 * ��Ŀ������
 * �������������ظ�Ԫ�ص������б�list1��list2��
 * ��������������в��ظ��������Ӽ���������
 * ��������ԭ����������
 *
 * ����������
 * ��һ�а���һ������N����ʾlist1��list2�ĳ��ȡ�
 * �ڶ��а���N�����ظ�����������ʾlist1��Ԫ�ء�
 * �����а���N�����ظ�����������ʾlist2��Ԫ�ء�
 *
 * ���������
 * ���һ����������ʾ���������Ĳ�ͬ���������е�������
 */

public class Main3 {
    static Set<List> set = new HashSet<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // �����б���
        int length = input.nextInt();
        // �洢 list1 ��Ԫ��
        List<Integer> list1 = new ArrayList<>(length);
        // �洢 list2 ��Ԫ��
        List<Integer> list2 = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            // ��ȡ list1 ��Ԫ��
            list1.add(input.nextInt());
        }
        for (int i = 0; i < length; i++) {
            // ��ȡ list2 ��Ԫ��
            list2.add(input.nextInt());
        }
        // �� list1 ���������Ӽ��Ĳ���
        test(list1);
        // �� list2 ���������Ӽ��Ĳ���
        test(list2);
        // �����ͬ�����Ӽ�������
        System.out.println(set.size());
    }

    // �����Ӽ����Һ���
    private static void test(List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        // ���û����㷨���������Ӽ�
        backTracking(list, 0);
    }

    // �����㷨���������Ӽ�
    private static void backTracking(List<Integer> list, int startIndex) {
        for (int i = startIndex; i < list.size(); i++) {
            // ��ȡ��ǰԪ����ԭ�����е�����
            int index1 = getIndex(list, list.get(i));
            int index2 = 0;
            if (path.size() != 0) {
                // ��ȡ��ǰ·�����һ��Ԫ����ԭ�����е�����
                index2 = getIndex(list, path.get(path.size() - 1));
            }

            if (path.size() == 0 || Math.abs(index1 - index2) == 1) {
                // ��ӵ�ǰԪ�ص�·��
                path.add(list.get(i));
                // ����ǰ·����Ϊ�����Ӽ���ӵ����������
                set.add(new ArrayList<>(path));
            } else {
                break;
            }
            // �ݹ������һ��Ԫ��
            backTracking(list, i + 1);
            // ���ݣ��Ƴ���ǰԪ��
            path.remove(path.size() - 1);
        }
    }

    // ��ȡԪ����ԭ�����е�����
    private static int getIndex(List<Integer> list, int num) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (num == list.get(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
