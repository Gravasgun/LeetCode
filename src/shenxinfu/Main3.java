package shenxinfu;

import java.util.*;

/**
 * ��Ŀ������
 * ����һ���������飬����Ҫ����������е�����ظ�������ĳ��ȡ�
 * ���ظ���������ָ�����е����������У��ڸ���������ÿ��Ԫ�ض����ظ����֡�
 * ����������
 *  [1, 2, 3, 4, 5, 1, 2, 3]
 *  ���������
 *  5 ���ͣ�����ظ�������Ϊ [1, 2, 3, 4, 5]������5��Ԫ�ء�
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (input.hasNextInt()) {
            list.add(input.nextInt());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int maxLength = getMaxLength(nums);
        System.out.println(maxLength);
    }

    private static int getMaxLength(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // ��¼����ظ�������ĳ���
        int maxLength = 0;
        // ���ظ����������߽�
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (!set.contains(nums[right])) {
                // �����ǰԪ�ز��ڼ����У�������뼯��
                set.add(nums[right]);
                // ��������ظ�������ĳ���
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                // �����ǰԪ���Ѿ��ڼ����У���Ҫ��С������ķ�Χ
                while (set.contains(nums[right])) {
                    // �Ƴ���߽�Ԫ�أ�ֱ����ǰԪ�ز��ڼ�����
                    set.remove(nums[left]);
                    left++;
                }
                // ����ǰԪ�ؼ��뼯��
                set.add(nums[right]);
            }
        }
        return maxLength;
    }
}
