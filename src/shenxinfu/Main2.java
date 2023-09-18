package shenxinfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ��Ŀ������
 * ����һ���ַ���������Ҫ���ɸ��ַ����������ַ����в������������ָ���ַ����е��ַ��������У��õ���ͬ��������ϡ�
 * ����ʾ����
 * ����: "abc"
 * ���ʾ����
 * ["abc", "acb", "bac", "bca", "cab", "cba"]
 */
public class Main2 {
    // ���ڴ洢������б�
    static List<List<String>> result = new ArrayList<>();
    // ���ڴ洢��ǰ·�����б�
    static List<String> paths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        // �������з���
        permute(s.toCharArray());
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                // �����н����ϳ��ַ��������
                sb.append(result.get(i).get(j));
            }
            System.out.println(sb);
        }
    }

    public static List<List<String>> permute(char[] chars) {
        // ������Ϊ�գ���ֱ�ӷ��ؽ���б�
        if (chars == null || chars.length == 0) {
            return result;
        }
        // ���û��ݷ�����������
        backTrack(chars);
        // ���ؽ���б�
        return result;
    }

    private static void backTrack(char[] chars) {
        // �����ǰ·���ĳ��ȵ�������ĳ��ȣ���ʾ�Ѿ�������һ������
        if (paths.size() == chars.length) {
            // ����ǰ·�����뵽����б���
            result.add(new ArrayList<>(paths));
            return;
        }
        // ���������е�ÿ���ַ�
        for (int i = 0; i < chars.length; i++) {
            // �����ǰ·���Ѿ��������ַ���˵�����ַ��Ѿ���ʹ�ù���ֱ������
            if (paths.contains(String.valueOf(chars[i]))) {
                continue;
            }
            // ����ǰ�ַ����뵽��ǰ·����
            paths.add(String.valueOf(chars[i]));
            // �ݹ�������һ���ַ�������
            backTrack(chars);
            // ���ݣ��Ƴ����һ��������ַ��������������ܵ�����
            paths.remove(paths.size() - 1);
        }
    }
}
