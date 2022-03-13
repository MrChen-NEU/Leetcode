package question222;

import DateStruct.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth == rightDepth){
            //左子树为满树，递归右子树
            return countNodes(root.right) + (1 << leftDepth);
        }else{
            //右子树为满树，递归左子树
            return countNodes(root.left) + (1 << rightDepth);
        }


    }

    //得到树的深度
    public int getDepth(TreeNode node){
        TreeNode root = node;
        int depth = 0;
        while(root != null){
            depth++;
            root = root.left;
        }
        return depth;
    }

}
