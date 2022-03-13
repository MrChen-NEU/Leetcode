import DateStruct.TreeNode;

//129. 求根节点到叶节点数字之和
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return nodeSum(root,0);
    }
    public int nodeSum(TreeNode root,int i){
        if(root == null) return 0;
        int temp = 10*i + root.val;
        if(root.left == null && root.right == null){
            return temp;
        }
        return nodeSum(root.left,temp) + nodeSum(root.right,temp);
    }
}
