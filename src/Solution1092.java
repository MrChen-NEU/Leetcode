import DateStruct.ListNode;
import DateStruct.TreeNode;

public class Solution1092 {
    public TreeNode sortedListToBST(ListNode head) {
        return BulidTree(head,null);
    }
    public TreeNode BulidTree(ListNode left,ListNode right){
        if(left == right) return null;
        ListNode mid = GetMid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = BulidTree(left,mid);
        root.right = BulidTree(mid.next,right);
        return root;
    }

    //寻找中位数 （快慢指针法）
    public ListNode GetMid(ListNode left,ListNode right){
        ListNode fast = left, slow = left;
        while(fast != right && fast.next != right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
