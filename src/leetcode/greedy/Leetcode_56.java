package leetcode.greedy;

import java.util.*;

/**
 * 56.�ϲ�����
 * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi]
 * ����ϲ������ص������䣬������ һ�����ص����������飬��������ǡ�ø��������е���������
 */
public class Leetcode_56 {
    public int[][] merge(int[][] intervals) {
        // ����һ���б����ڴ洢�ϲ��������
        List<int[]> list = new LinkedList<>();
        // �����������ʼλ�ý�����������
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        // ��ʼ����ǰ�ϲ��������ʼλ��Ϊ��һ���������ʼλ��
        int start = intervals[0][0];
        // ��ʼ����ǰ�ϲ�����Ľ���λ��Ϊ��һ������Ľ���λ��
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // ��ǰ�������ʼλ�ô��ڵ�ǰ�ϲ�����Ľ���λ�ã���ʾ�������䲻�ص�
            if (intervals[i][0] > end) {
                // ����ǰ�ϲ�������ӵ��б���
                list.add(new int[]{start, end});
                // ���µ�ǰ�ϲ��������ʼλ��Ϊ��ǰ�������ʼλ��
                start = intervals[i][0];
                // ���µ�ǰ�ϲ�����Ľ���λ��Ϊ��ǰ����Ľ���λ��
                end = intervals[i][1];
            } else {
                // ��ǰ������ǰһ���ϲ������ص������µ�ǰ�ϲ�����Ľ���λ��Ϊ�����������λ�õ����ֵ
                end = Math.max(end, intervals[i][1]);
            }
        }
        // �����һ���ϲ�������ӵ��б���
        list.add(new int[]{start, end});
        // ���б�ת��Ϊ��ά���鲢���ؽ��
        return list.toArray(new int[list.size()][]);
    }
}
