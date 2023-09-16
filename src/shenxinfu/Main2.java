package shenxinfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static List<List<String>> result = new ArrayList<>();  // ���ڴ洢������б�
    static List<String> paths = new ArrayList<>();  // ���ڴ洢��ǰ·�����б�

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        permute(s.toCharArray());
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                sb.append(result.get(i).get(j));
            }
            System.out.println(sb);
        }
    }

    public static List<List<String>> permute(char[] chars) {
        if (chars == null || chars.length == 0) {  // ������Ϊ�գ���ֱ�ӷ��ؽ���б�
            return result;
        }
        backTrack(chars);  // ���û��ݷ���
        return result;  // ���ؽ���б�
    }

    private static void backTrack(char[] chars) {
        if (paths.size() == chars.length) {  // �����ǰ·���ĳ��ȵ�������ĳ��ȣ���ʾ�Ѿ�������һ������
            result.add(new ArrayList<>(paths));// ����ǰ·�����뵽����б���
            return;
        }
        for (int i = 0; i < chars.length; i++) {  // ���������е�ÿ���ַ�
            if (paths.contains(String.valueOf(chars[i]))) {  // �����ǰ·���Ѿ��������ַ���˵�����ַ��Ѿ���ʹ�ù���ֱ������
                continue;
            }
            paths.add(String.valueOf(chars[i]));  // ����ǰ�ַ����뵽��ǰ·����
            backTrack(chars);  // �ݹ�������һ���ַ�������
            paths.remove(paths.size() - 1);  // ���ݣ��Ƴ����һ����������֣������������ܵ�����
        }
    }
}
