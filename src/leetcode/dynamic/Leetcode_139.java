package leetcode.dynamic;

import java.util.List;

public class Leetcode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // ����dp���飬��ʾ����Ϊiʱ����������ֵ��еĵ�����ɣ���ôdp[i]=true
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        // i�����ܳ���(�����±�) j������ʼ�±�
        // �������� �ȱ�������(s.length) �ٱ�����Ʒ(s.substring(j, i))
        for (int i = 1; i < result.length; i++) {
            // �ж� �ַ���s��λ��j��i���Ӵ��Ƿ��ڵ����ֵ��� ���� λ��j֮ǰ���Ӵ��Ѿ����Ա����Ϊ�����ֵ��еĵ���
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && result[j]) {
                    result[i] = true;
                }
            }
        }
        return result[result.length - 1];
    }
}
