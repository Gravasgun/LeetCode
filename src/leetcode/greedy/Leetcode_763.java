package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763.������ĸ����
 * ����һ���ַ��� s ������Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ��ĸ��������һ��Ƭ���С�
 * ע�⣬���ֽ����Ҫ���㣺�����л��ֽ����˳�����ӣ��õ����ַ�����Ȼ�� s��
 * ����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 */
public class Leetcode_763 {
    public List<Integer> partitionLabels(String s) {
        // ���ڴ洢������б�
        List<Integer> result = new ArrayList<>();
        // ���ַ���ת��Ϊ�ַ�����
        char[] chars = s.toCharArray();
        // ��ǰƬ�ε����ұ߽�
        int right = Integer.MIN_VALUE;
        // ��ʱ��������¼��һ��Ƭ�εĽ���λ��
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            // �������ұ߽�
            right = Math.max(right, findMaxIndex(chars[i], chars));
            // �����ǰλ���ǵ�ǰƬ�ε����ұ߽�
            if (i == right) {
                // ��Ƭ�γ��ȼ������б�
                result.add(right + 1 - temp);
                // ������ʱ����Ϊ��һ��Ƭ�ε���ʼλ��
                temp = right + 1;
            }
        }
        // ���ؽ���б�
        return result;
    }

    private int findMaxIndex(char c, char[] chars) {
        // �Ӻ���ǰ�����ַ�����
        for (int i = chars.length - 1; i >= 0; i--) {
            // �ҵ��ַ� c ���������λ��
            if (c == chars[i]) {
                // �����������λ��
                return i;
            }
        }
        // ���δ�ҵ��ַ� c���򷵻� -1
        return -1;
    }
}
