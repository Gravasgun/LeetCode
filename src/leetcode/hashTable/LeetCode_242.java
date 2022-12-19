package leetcode.hashTable;

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
}
