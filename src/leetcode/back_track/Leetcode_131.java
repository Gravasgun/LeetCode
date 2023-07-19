package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_131 {
    List<List<String>> result = new ArrayList<>(); // �洢���зָ�����б�
    List<String> paths = new ArrayList<>(); // �洢��ǰ�ָ�����б�

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result; // ����������������ַ���
        }
        backTrack(s, 0); // ���������㷨
        return result; // ���طָ���б�
    }

    private void backTrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                paths.add(s.substring(startIndex, i + 1));
                backTrack(s, i + 1);
                paths.remove(paths.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; j > i; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
