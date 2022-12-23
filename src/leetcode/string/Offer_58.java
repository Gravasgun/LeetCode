package leetcode.string;

public class Offer_58 {
    /**
     * ��ָOffer58-II.����ת�ַ���
     * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
     * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
     * ���磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        int index = n;
        int start = 0;
        //�������Ԫ�ذ�����ֵ���µ�char����
        for (int i = 0; i < chars.length - n; i++) {
            newChars[i] = chars[index++];
        }
        //���仯��Ԫ�ؼ���������ֵ���µ�char����
        for (int i = chars.length - n; i < chars.length; i++) {
            newChars[i] = chars[start++];
        }
        return new String(newChars);
    }
}
