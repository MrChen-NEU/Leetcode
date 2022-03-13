import DateStruct.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117_2 {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>(); //保存每一层的元素
        q.add(root);
        while(!q.isEmpty()){
            //每一层的数量
            int levelNum = q.size();
            Node pre = null;
            for (int i = 0; i < levelNum; i++) {
                Node node = q.poll(); //出队
                if(pre != null) pre.next = node;
                pre = node; //让当前节点成为前节点
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return root;
    }
}
