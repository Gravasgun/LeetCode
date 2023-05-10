package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 17.�绰�������ĸ���
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 */
public class Leetcode_17 {
    List<String> result = new ArrayList<>(); // �洢���յĽ���б�
    StringBuilder sb = new StringBuilder(); // ���������ַ���

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result; // ������Ϊ�ջ򳤶�Ϊ0����ֱ�ӷ��ؽ���б�
        }
        // �������Ӧ��ĸ��ӳ���ϵ
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(digits, numString, 0); // ���л����㷨
        return result; // ���ؽ���б�
    }

    private void backTrack(String digits, String[] numString, int index) {
        // ��������������ڵ绰���볤��ʱ����ʾ�Ѿ�������һ����������ĸ��ϣ�������ӵ�����б���
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // digits.charAt(index) - '0' �Ĳ������ַ�ת��Ϊ��Ӧ�����֡��ַ����Ϳ������������ͽ������㣬ͨ����ȥ�ַ� '0' �� ASCII ֵ�����Եõ���Ӧ�����֡�
        String str = numString[digits.charAt(index) - '0']; // ��ȡ��ǰ���ֶ�Ӧ����ĸ����
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)); // ����ǰ��ĸ��ӵ��ַ�����������
            backTrack(digits, numString, index + 1); // �ݹ鴦����һ����������Ӧ���ַ���
            sb.deleteCharAt(sb.length() - 1); // ���ݣ�ɾ�������ӵ���ĸ���Ա㴦����һ����ĸ
        }
    }
}
