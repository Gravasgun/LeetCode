package leetcode.tree;

/**
 * 654.��������
 * ����һ�����ظ�����������nums ��������������������㷨��nums�ݹ�ع���:
 * ����һ�����ڵ㣬��ֵΪnums�е����ֵ��
 * �ݹ�������ֵ��ߵ�������ǰ׺�Ϲ�����������
 * �ݹ�������ֵ�ұߵ��������׺�Ϲ�����������
 * ����nums�������������� ��
 */
public class Leetcode_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // �������Ϊ�գ��򷵻� null
        if (nums.length == 0) {
            return null;
        }
        // �ҵ������е����ֵ�����±�
        int[] array = findMaxNum(nums);
        int maxIndex = array[1];
        TreeNode root = new TreeNode(array[0]);
        // ����������������
        int[] left = new int[maxIndex];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }
        // ����������������
        int[] right = new int[nums.length - 1 - maxIndex];
        int rightIndex = 0;
        for (int i = maxIndex + 1; i < nums.length; i++) {
            right[rightIndex++] = nums[i];
        }
        // �ݹ鹹����������
        TreeNode leftNode = constructMaximumBinaryTree(left);
        TreeNode rightNode = constructMaximumBinaryTree(right);
        // �������������ӵ����ڵ�
        root.left = leftNode;
        root.right = rightNode;
        // ���ظ��ڵ�
        return root;
    }

    // �ҵ������е����ֵ�����±�
    public int[] findMaxNum(int[] nums) {
        int maxIndex = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // ����ҵ��ȵ�ǰ���ֵ�����������������ֵ���±�
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{maxNum, maxIndex};
    }
}
