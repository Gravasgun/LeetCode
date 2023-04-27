package leetcode.tree;

/**
 * 105.��ǰ��������������й��������
 * ����������������preorder��inorder������preorder�Ƕ��������������,inorder��ͬһ����������������빹�����������������ڵ㡣
 */
public class Leetcode_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // ���ǰ���������Ϊ�գ����ؿսڵ�
        if (preorder.length == 0) {
            return null;
        }
        // ȡǰ��������еĵ�һ��ֵ��Ϊ���ڵ��ֵ
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        // ���ǰ��������г���Ϊ1��ֱ�ӷ��ظ��ڵ�
        if (preorder.length == 1) {
            return root;
        }

        // ��������������в��Ҹ��ڵ��ֵ���ҵ������ȷ�����������������������
        int index = 0;
        for (; index < inorder.length; index++) {
            if (rootValue == inorder[index]) {
                break;
            }
        }

        // �����������������������
        int[] leftInorderList = new int[index];
        for (int i = 0; i < leftInorderList.length; i++) {
            leftInorderList[i] = inorder[i];
        }

        // �����������������������
        int[] rightInorderList = new int[inorder.length - 1 - index];
        int rightInorderIndex = 0;
        for (int i = index + 1; i < inorder.length; i++) {
            rightInorderList[rightInorderIndex++] = inorder[i];
        }

        // ������������ǰ���������
        int[] leftPreorderList = new int[leftInorderList.length];
        int leftPreorderIndex = 0;
        for (int i = 1; i < 1 + leftPreorderList.length; i++) {
            leftPreorderList[leftPreorderIndex++] = preorder[i];
        }

        // ������������ǰ���������
        int[] rightPreorderList = new int[preorder.length - 1 - leftPreorderList.length];
        int rightPreorderIndex = 0;
        for (int i = leftPreorderIndex + 1; i < preorder.length; i++) {
            rightPreorderList[rightPreorderIndex++] = preorder[i];
        }

        // �ݹ鹹��������������������������Ϊ���ڵ�������ӽڵ�
        TreeNode leftNode = buildTree(leftPreorderList, leftInorderList);
        TreeNode rightNode = buildTree(rightPreorderList, rightInorderList);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
