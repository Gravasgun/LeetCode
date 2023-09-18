package shenxinfu;

import java.util.*;

/**
 * ��Ŀ������
 * ����һ���ַ���������Ҫ��������ַ����в�ͬ�ַ������п��������Ŀ��Ȼ������������
 * ����ʾ����
 * abac
 * ���ʾ����
 * 5 ���ͣ���ͬ�ַ�������� ["a", "b", "c", "ab", "ac"]������5����ϡ�
 */
public class Main {

    // �洢������Ͻ�����б�
    static List<List<String>> result = new ArrayList<>();
    // �洢��ǰ���·�����б�
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        // ��ȡ�ַ����в�ͬ�ַ����Ӵ�
        String differentString = getDifferentString(s);
        // ���㲻ͬ�ַ��������
        getCombinationNum(differentString.toCharArray());
        // ������������1����Ϊ�ռ���Ҳ���������ڣ�
        System.out.println(result.size() - 1);
    }

    // �����������������
    private static List<List<String>> getCombinationNum(char[] chars) {
        if (chars == null || chars.length == 0) {
            return result;
        }
        // �����㷨�����������
        backTrack(chars, 0);
        return result;
    }

    // �����㷨�ĺ��ĺ���
    private static void backTrack(char[] chars, int startIndex) {
        // ����ǰ��ϼ������б�
        result.add(new ArrayList<>(path));
        if (startIndex >= chars.length) {
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            // ����ǰԪ�ؼ��뵱ǰ�Ӽ�
            path.add(String.valueOf(chars[i]));
            // �ݹ�������һ���Ӽ�����ʼ����Ϊ��ǰԪ�ص���һ��λ��
            backTrack(chars, i + 1);
            // ���ݲ����������һ�������Ԫ���Ƴ�������������һ���Ӽ�
            path.remove(path.size() - 1);
        }
    }

    // ��ȡ�ַ����в�ͬ�ַ����Ӵ�
    private static String getDifferentString(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}