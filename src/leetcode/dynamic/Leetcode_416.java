package leetcode.dynamic;

import java.util.Arrays;

public class Leetcode_416 {
    public boolean canPartition(int[] nums) {
        // �������
        int sum = Arrays.stream(nums).sum();
        // ���sum����2�ı��� ֱ�ӷ���false
        if (sum % 2 != 0) {
            return false;
        }
        // �󱳰�����
        int size = sum / 2;
        // ����dp����
        int[] result = new int[size + 1];
        // ������Գ���Ϊ �󱳰�����Ϊj������ֵ�Ƿ�ҲΪj
        for (int i = 0; i < nums.length; i++) {
            for (int j = result.length - 1; j >= nums[i]; j--) {
                result[j] = Math.max(result[j], result[j - nums[i]] + nums[i]);
            }
        }
        return result[result.length - 1] == size;
    }
}
