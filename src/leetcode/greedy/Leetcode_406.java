package leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406.��������ؽ�����
 * �����д���˳���һȺ��վ��һ�����У����� people ��ʾ������һЩ�˵����ԣ���һ����˳�򣩡�
 * ÿ�� people[i] = [hi, ki] ��ʾ�� i ���˵����Ϊ hi ��ǰ�� ���� �� ki ����ߴ��ڻ���� hi ���ˡ�
 * �������¹��첢������������ people ����ʾ�Ķ��С����صĶ���Ӧ�ø�ʽ��Ϊ���� queue
 * ���� queue[j] = [hj, kj] �Ƕ����е� j ���˵����ԣ�queue[0] �����ڶ���ǰ����ˣ���
 */
public class Leetcode_406 {
    public int[][] reconstructQueue(int[][] people) {
        // �ֲ����ţ����Ȱ���� �ߵ�people��k ������ ����������people�����������
        // ȫ�����ţ������������������������������Ŀ��������

        // ������߽������У���������ͬ������ k ֵ��������
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        // ����һ�����ڴ洢�ع����е��б�
        List<int[]> queue = new LinkedList<>();
        // ���������� people ����
        for (int[] person : people) {
            // ����ǰ�˲��뵽��Ӧ��λ��
            // ���� k ֵ����ǰ�˲��뵽�б��ָ������λ��
            // ��Ϊ�� LinkedList �в���Ԫ�ػὫ�����Ԫ�غ��ƣ����Կ���ֱ�Ӳ��뵽ָ��������λ��
            queue.add(person[1], person);
        }
        // ���б�ת��Ϊ��ά���鲢����
        return queue.toArray(people);
    }
}
