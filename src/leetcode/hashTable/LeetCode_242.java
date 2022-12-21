package leetcode.hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode_242 {
    /**
     * 242.��Ч����ĸ��λ��
     * ���������ַ���s��t����дһ���������ж�t�Ƿ���s����ĸ��λ�ʡ�
     * ��s��t��ÿ���ַ����ֵĴ�������ͬ�����s��t��Ϊ��ĸ��λ�ʡ�
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //�ж������ַ��������Ƿ���ȣ��������ֱ�ӷ���false
        if (s.length() != t.length()) {
            return false;
        }
        //����һ�����飬����¼�ַ���s���ַ����ֵĴ�����
        int[] arr = new int[26];
        //0~25��Ӧ��ĸa~z
        //�����һ����ĸ��a����ôs.charAt(i) - 'a'=0��arr[0]++,�ͼ�¼��a���ַ����г��ֵĴ���
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        //����������飬ֻҪ�����г���һ��Ԫ�ز�Ϊ0���������ַ����Ͳ�����Ч����ĸ��λ��
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        //��������Ԫ�ض�Ϊ��0��˵���ַ���s��t����ĸ��λ��
        return true;
    }

    public boolean isAnagramMethodTwo(String s, String t) {
        //�ж������ַ��������Ƿ���ȣ��������ֱ�ӷ���false
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        //����s�������ַ�����s��ÿһ���ַ���Ϊkey��ÿһ���ַ����ֵĴ�����Ϊvalue������map
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        //����t�������ַ�
        for (Character c : t.toCharArray()) {
            //���map�в�����t�е�����һ���ַ�������false
            if (!map.containsKey(c)) {
                return false;
            } else {
                //��������ˣ���Ѹ��ַ��Ĵ���-1
                map.put(c, map.get(c) - 1);
            }
        }

        //����map
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            //ֻҪmap�е�value��һ��������0��˵��s��t��������һ�����ַ�
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
