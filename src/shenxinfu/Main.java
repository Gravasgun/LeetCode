package shenxinfu;

import java.util.*;

public class Main {
    static List<List<String>> result = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        //System.out.println(s);
        String differentString = getDifferentString(s);
        //System.out.println(differentString);
        getCombinationNum(differentString.toCharArray());
        System.out.println(result.size()-1);
    }

    private static List<List<String>> getCombinationNum(char[] chars) {
        if (chars == null || chars.length == 0) {
            return result;
        }
        backTrack(chars, 0);
        return result;
    }

    private static void backTrack(char[] chars, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= chars.length) {
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            path.add(String.valueOf(chars[i])); // ����ǰԪ�ؼ��뵱ǰ�Ӽ�
            backTrack(chars, i + 1); // �ݹ�������һ���Ӽ�����ʼ����Ϊ��ǰԪ�ص���һ��λ��
            path.remove(path.size() - 1); // ���ݲ����������һ�������Ԫ���Ƴ�������������һ���Ӽ�
        }
    }


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