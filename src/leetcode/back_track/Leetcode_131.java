package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 131.�ָ���Ĵ�
 * ����һ���ַ��� s�����㽫 s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����� ���Ĵ� ������ s ���п��ܵķָ����
 * ���Ĵ� �����Ŷ��ͷ��Ŷ���һ�����ַ�����
 */
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
            result.add(new ArrayList<>(paths)); // ��startIndexԽ��ʱ������ǰ�ָ����ӵ�����б���
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) { // �����ǰ�Ӵ��ǻ��Ĵ�
                paths.add(s.substring(startIndex, i + 1)); // ��[0,i]�����Ӵ���ӵ���ǰ�ָ����
                backTrack(s, i + 1); // �ݹ鴦��ʣ�ಿ��
                paths.remove(paths.size() - 1); // ���ݣ��Ƴ����һ�������Ӵ������������ָ��
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) { // ���������ʣ��Գ�λ���ַ����
                return false; // �������������������false
            }
        }
        return true; // �Ӵ��ǻ��Ĵ�������true
    }
}