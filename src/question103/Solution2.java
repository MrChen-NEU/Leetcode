package question103;

import DateStruct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>(); //总集合
        List<Integer> list = new ArrayList<>();  //每一层的集合
        dfs(lists,list,1,root);
        for (int i = 1; i < lists.size(); i += 2) {
            Collections.reverse(lists.get(i));  //层数为双数时反转集合元素
        }
        return lists;
    }

    public void dfs(List<List<Integer>> lists,List<Integer> list,int deep,TreeNode root){
        if(root == null) return;
        if(deep > lists.size()){ //当遍历到每层的第一个元素时，需要创建新的一个集合存储元素
            lists.add(new ArrayList<>());
        }
        lists.get(deep - 1).add(root.val); //将元素的值加入到集合中
        dfs(lists, list, deep+1, root.left); //遍历左子树
        dfs(lists, list, deep+1, root.right); //遍历右子树
    }
}
