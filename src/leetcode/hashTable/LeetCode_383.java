package leetcode.hashTable;

public class LeetCode_383 {
    /**
     * 383.�����
     * ���������ַ�����ransomNote �� magazine ���ж� ransomNote �ܲ����� magazine ������ַ����ɡ�
     * ������ԣ����� true �����򷵻� false ��
     * magazine�е�ÿ���ַ�ֻ���� ransomNote ��ʹ��һ�Ρ�
     * @param ransomNote ������ַ���
     * @param magazine ��־�ַ���
     * @return ��� magazine ������������ ransomNote������ true�����򷵻� false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // ��ʼ������Ϊ 26 ���������飬���ڼ�¼ magazine ��ÿ���ַ����ֵĴ���
        int[] list = new int[26];
        // ���� magazine �е�ÿ���ַ��������ַ����ֵĴ���
        for (char c : magazine.toCharArray()) {
            list[c - 'a']++; // �����ֹ����ַ��ļ����� 1
        }
        // ���� ransomNote �е�ÿ���ַ������������ж�Ӧ�ַ��ļ���
        for (char c : ransomNote.toCharArray()) {
            list[c - 'a']--; // ����Ӧ�ַ��ļ����� 1
        }
        // �������飬������κ�һ���ַ��ļ���С���㣬˵���޷����� ransomNote������ false
        for (int i : list) {
            if (i < 0) {
                return false;
            }
        }
        // �������������û�з��� false����˵�������� magazine ���� ransomNote������ true
        return true;
    }
}
