package question103;

import DateStruct.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(lists, list, 1, root);
        for (int i = 1; i < lists.size(); i += 2) {
            Collections.reverse(lists.get(i)); //层数为双数的集合的元素的顺序反转
        }
        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> list, int deep, TreeNode root) {
        if (root == null) {
            return;
        }
        if (deep > lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(deep - 1).add(root.val);
        dfs(lists, list, deep + 1, root.left);
        dfs(lists, list, deep + 1, root.right);
    }
}