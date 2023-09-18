package rongyao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ����һ���������ֺ������ַ����ַ���������Ҫ������ȡ�����ַ����������������������Щ���֡�
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // �ж��ַ��Ƿ�Ϊ����
            if (Character.isDigit(chars[i])) {
                // �������ַ�ת��Ϊ��������ӵ��б���
                list.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
        // ���б��е�����ת��Ϊ��������
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        // ���������������������
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // ��ӡ����������
            System.out.print(nums[i]);
        }
    }
}
