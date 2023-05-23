package leetcode.greedy;

import java.util.Arrays;

/**
 * 435.���ص�����
 * ����һ������ļ��� intervals ������ intervals[i] = [starti, endi] ������ ��Ҫ�Ƴ��������С������ʹʣ�����以���ص� ��
 */
public class Leetcode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // �����������ʼλ�ý�������
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int count = 1; // ����������ʾ���ظ������䣬��ʼ��Ϊ1�����ٱ���һ������

        for (int i = 1; i < intervals.length; i++) {
            // �����ǰ�������ʼλ�ô��ڵ���ǰһ������Ľ���λ�ã�˵���������䲻�ص�
            if (intervals[i][0] >= intervals[i - 1][1]) {
                count++; // ��������1����ʾ������ǰ����
            } else {
                // ��ǰ������ǰһ�������ص�
                // ���µ�ǰ����Ľ���λ��Ϊǰһ������Ľ���λ�ú͵�ǰ����Ľ���λ���еĽ�Сֵ
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        // ������Ҫɾ������С������
        return intervals.length - count;
    }
}
