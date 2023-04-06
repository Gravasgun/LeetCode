package leetcode.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 347.ǰK����ƵԪ��
 * ����һ���������� nums ��һ������ k �����㷵�����г���Ƶ��ǰ k �ߵ�Ԫ�ء�����԰� ����˳�� ���ش𰸡�
 */
public class Leetcode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // ����һ����ϣ������¼ÿ�����ֳ��ֵĴ���
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) { // �����ϣ����û��������֣�������ӵ���ϣ���У������ó��ִ���Ϊ 0
                map.put(num, 0);
            } else { // �����ϣ�����Ѿ���������֣�������ִ����� 1
                Integer count = map.get(num);
                map.put(num, ++count);
            }
        }
        // ����һ��С�������洢���ִ�����ߵ� k ������
        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        // ������ϣ���е�ÿһ�Լ�ֵ��
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            // ���С�����е�Ԫ�ظ���С�� k��ֱ�ӽ��ü�ֵ����ӵ�С������
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else { // ���򣬱Ƚ�С�����е���Сֵ�͵�ǰ��ֵ�Եĳ��ִ�����������߸����滻С�����е���Сֵ
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // ��С�����е�Ԫ��ת�Ƶ����������
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll()[0];
        }
        return arr;
    }
}