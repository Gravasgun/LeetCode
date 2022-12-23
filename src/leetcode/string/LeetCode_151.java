package leetcode.string;

public class LeetCode_151 {
    /**
     * 151.��ת�ַ����еĵ���
     * ����һ���ַ���s�����㷴ת�ַ����е��ʵ�˳��
     * �������ɷǿո��ַ���ɵ��ַ�����s��ʹ������һ���ո��ַ����еĵ��ʷָ�����
     * ���ص���˳��ߵ��ҵ���֮���õ����ո����ӵĽ���ַ�����
     * �����ַ���s�п��ܻ����ǰ���ո�β��ո���ߵ��ʼ�Ķ���ո񡣷��صĽ���ַ����У����ʼ�Ӧ�����õ����ո�ָ����Ҳ������κζ���Ŀո�
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        //1.ȥ����β�Լ��м����ո�
        chars = removeExtraSpaces(chars);
        //2.�����ַ�����ת
        reverse(chars, 0, chars.length - 1);
        //3.���ʷ�ת
        reverseEachWord(chars);
        return new String(chars);
    }

    //���ʷ�ת
    public void reverseEachWord(char[] chars) {
        int startIndex = 0;
        //�����=����Ϊ����endIndex��Զָ�򵥴�ĩ��β��һ��λ�ã����� reverse ��ʵ�θ�������
        for (int endIndex = 0; endIndex <= chars.length; endIndex++) {
            if (endIndex == chars.length || chars[endIndex] == ' ') {
                reverse(chars, startIndex, endIndex - 1);
                startIndex = endIndex + 1;
            }
        }
    }

    //��ת�ַ���
    public void reverse(char[] chars, int i, int j) {
        if (j >= chars.length) {
            System.out.println("set a wrong right");
            return;
        }
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    //�ÿ���ָ��ȥ����β�Լ��м����ո�
    public char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            //����fast�Ƴ����пո�
            if (chars[fast] != ' ') {
                //��slow�ӿո�,����һ�������⣬����ĩβҪ�ӿո�
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                //fast�����ո��������ַ���ĩβ����֤��������һ��������
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        char[] newChars = new char[slow];
        //���������е�Ԫ��
        for (int i = 0; i < slow; i++) {
            newChars[i] = chars[i];
        }
        return newChars;
    }
}
