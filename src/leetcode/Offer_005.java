package leetcode;

public class Offer_005 {
    /**
     * ��ָoffer005.�滻�ո�
     * ��ʵ��һ�����������ַ���s�е�ÿ���ո��滻��"%20"��
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        //Java�У��ַ���������Ƴɲ��ɱ�����ͣ����޷�ֱ���޸��ַ�����ĳһλ�ַ�����Ҫ�½�һ���ַ���ʵ�֡�
        StringBuilder str = new StringBuilder();
        //����s�е�ÿ���ַ�c��
        for (Character c : s.toCharArray()) {
            //��cΪ�ո�ʱ����res������ַ���"%20"��
            if (c == ' ') {
                str.append("%20");
            } else {
                //��c��Ϊ�ո�ʱ����res������ַ�c��
                str.append(c);
            }
        }
        return str.toString();
    }
}
