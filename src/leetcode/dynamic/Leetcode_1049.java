package leetcode.dynamic;

import java.util.Arrays;

/**
 * 1049.���һ��ʯͷ������II
 * ��һ��ʯͷ������������ stones ��ʾ������ stones[i] ��ʾ�� i ��ʯͷ��������
 * ÿһ�غϣ�����ѡ����������ʯͷ��Ȼ������һ����顣����ʯͷ�������ֱ�Ϊ x �� y���� x <= y����ô����Ŀ��ܽ������
 * ��� x == y����ô����ʯͷ���ᱻ��ȫ���飻
 * ��� x != y����ô����Ϊ x ��ʯͷ������ȫ���飬������Ϊ y ��ʯͷ������Ϊ y-x��
 * ������ֻ��ʣ��һ�� ʯͷ�����ش�ʯͷ ��С�Ŀ������� �����û��ʯͷʣ�£��ͷ��� 0��
 */
public class Leetcode_1049 {
    /**
     * ��ʯͷ�ֳ�������ͬ�����ѣ���ײ֮��ʣ�µ�ʯͷ��С�������ͻ����01����������
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        // �������Ϊ�ջ���������ûԪ�� ֱ�ӷ���0
        if (stones == null || stones.length == 0) {
            return 0;
        }
        // ����ʯͷ������ܺ�
        int sum = Arrays.stream(stones).sum();
        // Ŀ��ֵΪ�ܺ͵�һ��
        int target = sum / 2;
        // ���ڱ����м���������
        int[] result = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = result.length - 1; j >= stones[i]; j--) {
                // ��̬�滮���½������
                // ��ǰʯͷ������ stones[i] <= j������ѡ�����򲻷��뱳��
                // Math.max(result[j], result[j - stones[i]] + stones[i]) ��ʾ�ڷ���򲻷��뵱ǰʯͷ������ѡ����ѡ��ϴ��ֵ
                result[j] = Math.max(result[j], result[j - stones[i]] + stones[i]);
            }
        }
        // ��������ʯͷ�����������Сֵ
        // �ܺͼ�ȥ������������ʯͷ������֮�ͼ�Ϊ���
        return sum - 2 * result[result.length - 1];
    }
}
