package leetcode.tree;

/**
 * 108.����������ת��Ϊ����������
 * ����һ���������� nums ������Ԫ���Ѿ��� ���� ���У����㽫��ת��Ϊһ�� �߶�ƽ�� ������������
 * �߶�ƽ�� ��������һ�����㡸ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ���Ķ�������
 */
public class Leetcode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildSearchTree(nums, 0, nums.length - 1);
    }

    /**
     * �ݹ鹹������������
     *
     * @param nums  ��������
     * @param left  ��ǰ���������ʼ����
     * @param right ��ǰ������Ľ�������
     * @return �����õ��Ķ����������ĸ��ڵ�
     */
    private TreeNode buildSearchTree(int[] nums, int left, int right) {
        // �ݹ���ֹ���������������������������˵����ǰ������Ϊ�գ�����null
        if (left > right) {
            return null;
        }
        // �����м�Ԫ�ص�����
        int mid = (left + right) / 2;
        // ������ǰ�м�Ԫ����Ϊ���ڵ�Ķ������ڵ�
        TreeNode root = new TreeNode(nums[mid]);
        // �ݹ鹹�����������������鷶Χ�Ǵ�left��mid-1
        root.left = buildSearchTree(nums, left, mid - 1);
        // �ݹ鹹�����������������鷶Χ�Ǵ�mid+1��right
        root.right = buildSearchTree(nums, mid + 1, right);
        // ���ع����õ��Ķ����������ĸ��ڵ�
        return root;
    }
}
