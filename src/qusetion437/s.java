package qusetion437;

import DateStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class s {
    Map<Integer,Integer> m = new HashMap<Integer,Integer>();//保存前缀树
    int target;
    public int pathSum(TreeNode root, int targetSum){
        target = targetSum;
        m.put(0,1);
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum + root.val;
        int sum1 = 0;
        sum1 = m.getOrDefault(sum-target,0);
        m.put(sum,m.getOrDefault(sum,0)+1); //保存当前节点到哈希表
        int sum_left = dfs(root.left,sum); //遍历左子树
        int sum_right = dfs(root.right,sum); //遍历右子树
        m.put(sum,m.get(sum)-1);  //恢复，在遍历完一个节点的所有子节点后，将其从map中除去。
        return (sum1 + sum_left + sum_right);

    }
}
