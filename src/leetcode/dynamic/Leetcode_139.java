package leetcode.dynamic;

import java.util.List;

/**
 * 139.���ʲ��
 * ����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣�����ж��Ƿ���������ֵ��г��ֵĵ���ƴ�ӳ� s ��
 * ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�
 */
public class Leetcode_139 {
    /**
     * ����������Ϊ��ȫ�������� �ַ����ĳ���Ϊ�������� �ֵ��еĵ���Ϊ��Ʒ(�Ӵ�)
     * �󣺲�ͬ��Ʒ�����У��ܷ�װ���������
     *
     * @param s �ַ���(����Ϊ��������)
     * @param wordDict �ֵ�(�ֵ��е�ÿ��Ԫ��Ϊ��Ʒ)
     * @return ��������ֵ��еĵ������г��ַ���s������true
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // ����dp���飬��ʾ����Ϊiʱ����������ֵ��еĵ�����ɣ���ôdp[i]=true
        boolean[] result = new boolean[s.length() + 1];
        // ��result[0]��ʼ��Ϊtrue��Ϊ�˵��Ƴ������Ԫ��
        result[0] = true;
        // ���ѭ�������������ڲ�ѭ��������Ʒ(�Ӵ�)
        // ���������� ��ΪҪ���ֵ���Ԫ�ص�˳�� �����ȱ����������ٱ�����Ʒ
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                // �ж� �ַ���s��λ��j��i���Ӵ��Ƿ��ڵ����ֵ��� ���� λ��j֮ǰ���Ӵ��Ѿ����Ա����Ϊ�����ֵ��еĵ���
                if (wordDict.contains(s.substring(j, i)) && result[j]) {
                    // ���������������result[i]����Ϊtrue��
                    // ��ʾ�ַ���s��λ��0��i���Ա����Ϊ�����ֵ��еĵ���
                    result[i] = true;
                }
            }
        }
        // ����result��������һ��Ԫ�أ���ʾ�ַ���s�Ƿ���Ա����Ϊ�����ֵ��еĵ���
        return result[result.length - 1];
    }
}
