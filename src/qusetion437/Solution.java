package qusetion437;

import DateStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer,Integer> mem = new HashMap<Integer,Integer>();//保存前缀树
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        mem.put(0,1); //前缀树为0的个数至少是一个
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int curSum){
        if(root == null) return 0;
        curSum += root.val;//得到当前前缀树的值
        int res = 0;

        //得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
        res = mem.getOrDefault(curSum-target,0);

        //将当前前缀树的值保存
        mem.put(curSum,mem.getOrDefault(curSum,0)+1);

        int left = dfs(root.left,curSum); //遍历左边
        int right = dfs(root.right,curSum); //遍历右边
        mem.put(curSum,mem.get(curSum)-1); //还原
        return res+left+right; //结果是当前节点前缀树的个数加上左边满足的个数加右边满足的个数
    }
}

