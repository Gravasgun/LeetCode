package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

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
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = numString[Integer.parseInt(String.valueOf(digits.charAt(index)))];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTrack(digits, numString, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
