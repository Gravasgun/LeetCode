package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_1049 {
    public int lastStoneWeightII(int[] stones) {
        // ���
        int sum = Arrays.stream(stones).sum();
        // �󱳰�����
        int size = sum / 2;
        // ����dp����
        int[] result = new int[size + 1];
        // ���dp���� �ȱ�����Ʒ �ٱ������� �����������
        for (int i = 0; i < stones.length; i++) {
            for (int j = result.length - 1; j >= stones[i]; j--) {
                result[j] = Math.max(result[j], result[j - stones[i]] + stones[i]);
            }
        }
        // ����ʣʯͷ��С �����󱳰�����һ��������������װ����
        return sum - 2 * result[result.length - 1];
    }
}
