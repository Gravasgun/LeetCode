package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.��ԭIP��ַ
 * ��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
 * ����һ��ֻ�������ֵ��ַ��� s �����Ա�ʾһ�� IP ��ַ���������п��ܵ���Ч IP ��ַ����Щ��ַ����ͨ���� s �в��� '.' ���γɡ�
 * �� ���� ���������ɾ�� s �е��κ����֡�����԰� �κ� ˳�򷵻ش𰸡�
 */
public class Leetcode_93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() > 12 || s.length() == 0) {
            return result;
        }
        backTrack(s, 0, 0);
        return result;
    }

    private void backTrack(String s, int startIndex, int pointNumber) {
        // ����Ѿ���3����ţ���ʣ�ಿ����һ���Ϸ���IP��ַ������ӵ�����б�
        if (pointNumber == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        // �ڵ�ǰλ�ó�����ӵ�ţ�Ȼ������ݹ�
        for (int i = startIndex; i < s.length(); i++) {
            // �жϴ�startIndex��i���Ӵ��Ƿ���һ���Ϸ�������
            if (isValid(s, startIndex, i)) {
                // ��iλ����ӵ��
                /**
                 * ��ÿ�εݹ�ʱ�����ǻ��ڵ�ǰλ�ó������һ����ţ����������ӵ��ַ��� s �С�
                 * ������Ǵ� startIndex ��ʼ������ô���ŵݹ�Ľ��У��ַ��� s �ĳ��Ƚ��᲻����С��
                 * ��ᵼ�º����ĵݹ鴦��ֻ������С����ַ����Ͻ��У��޷���ȡ������ԭʼ�ַ�����
                 * ���������д�����ѡ��0������startIndex
                 */
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNumber++;
                // �ݹ鴦����һ����ź��λ��
                // ��Ϊ����һ��"."�����Ի��ݵ�startIndexӦ����i+2
                backTrack(s, i + 2, pointNumber);
                // ���ݣ�ȥ����ӵĵ��
                pointNumber--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                // ���ǺϷ������֣�ֱ���˳�ѭ��
                break;
            }
        }
    }

    private boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        // ��0��ͷ�Ķ�λ�����Ϸ�
        if (s.charAt(startIndex) - '0' == 0 && endIndex != startIndex) {
            return false;
        }
        // ���Ӵ�ת��Ϊ����
        int number = Integer.parseInt(s.substring(startIndex, endIndex + 1));
        // �ж������Ƿ���0~255֮��
        if (number < 0 || number > 255) {
            return false;
        }
        return true;
    }
}