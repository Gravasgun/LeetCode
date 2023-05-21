package leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 860.����ˮ����
 * ������ˮ̯�ϣ�ÿһ������ˮ���ۼ�Ϊ 5 ��Ԫ���˿��Ŷӹ�����Ĳ�Ʒ�������˵� bills ֧����˳��һ�ι���һ����
 * ÿλ�˿�ֻ��һ������ˮ��Ȼ�����㸶 5 ��Ԫ��10 ��Ԫ�� 20 ��Ԫ��������ÿ���˿���ȷ���㣬Ҳ����˵��������ÿλ�˿�����֧�� 5 ��Ԫ��
 * ע�⣬һ��ʼ����ͷû���κ���Ǯ��
 * ����һ���������� bills ������ bills[i] �ǵ� i λ�˿͸����ˡ�������ܸ�ÿλ�˿���ȷ���㣬���� true �����򷵻� false ��
 */
public class Leetcode_860 {
    public boolean lemonadeChange(int[] bills) {
        // ����һ��֧���ĳ�Ʊ�Ƿ�Ϊ5��Ԫ���Լ��ڶ���֧���ĳ�Ʊ�Ƿ�Ϊ20��Ԫ
        if (bills[0] != 5 || bills[1] == 20) {
            return false;
        }
        // ����һ�� HashMap ���ڼ�¼���и������ĳ�Ʊ����
        Map<Integer, Integer> map = new HashMap<>();
        // �����˿�֧���ĳ�Ʊ
        for (int i = 0; i < bills.length; i++) {
            // ���� HashMap �ж�Ӧ���ĳ�Ʊ����
            if (map.get(bills[i]) == null) {
                map.put(bills[i], 1);
            } else {
                Integer num = map.get(bills[i]);
                map.put(bills[i], num + 1);
            }
            // ���֧���ĳ�Ʊ���Ϊ10��Ԫ
            if (bills[i] == 10) {
                // ����Ƿ���5��Ԫ�ĳ�Ʊ����������
                if (map.get(5) < 1) {
                    return false; // �޷����㣬����false
                } else {
                    // ����5��Ԫ
                    map.put(5, map.get(5) - 1);
                }
            }
            // ���֧���ĳ�Ʊ���Ϊ20��Ԫ
            if (bills[i] == 20) {
                // ����ʹ��һ��10��Ԫ��һ��5��Ԫ��������
                // �ֲ����ţ������˵�20������������Ԫ10����ɱ�������
                // ȫ�����ţ����ȫ���˵�������
                if (map.get(10) != null && map.get(5) != null && map.get(10) >= 1 && map.get(5) >= 1) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else if (map.get(5) >= 3) {
                    // ���û���㹻��10��Ԫ��Ʊ��������������5��Ԫ��Ʊ
                    map.put(5, map.get(5) - 3);
                } else {
                    return false; // �޷����㣬����false
                }
            }
        }
        return true; // ���й˿Ͷ�����ɹ�������true
    }
}