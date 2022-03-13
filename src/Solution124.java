import DateStruct.TreeNode;

//124. 二叉树中的最大路径和
public class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0; //递归结束

        //若左右分支返回的值为负数，则对路径和做负贡献，直接舍弃
        int lefMax = Math.max(0,dfs(root.left));
        int rightMax = Math.max(0,dfs(root.right));

        //由于路径最大的一种可能为left->node->right，而不向root的父结点延伸
        int lnr = root.val + lefMax + rightMax;

        //更新最大值，全是负数结点的情况，也会在这里更新最大的负数
        max = Math.max(max, lnr);

        //向root的父结点返回经过root的单边分支的最大路径和
        int ret = root.val + Math.max(lefMax,rightMax);
        return ret;
    }
}
