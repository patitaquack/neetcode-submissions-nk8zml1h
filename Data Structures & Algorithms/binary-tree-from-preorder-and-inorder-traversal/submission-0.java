class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1,
                      inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        // Base case:
        
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the root in inorder
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Number of nodes in the left subtree
        int leftSize = rootIndex - inStart;

        // Build left subtree
        root.left = helper(preorder, preStart + 1, preStart + leftSize,
                           inorder, inStart, rootIndex - 1);

        // Build right subtree
        root.right = helper(preorder, preStart + leftSize + 1, preEnd,
                            inorder, rootIndex + 1, inEnd);

        return root;
    }
}