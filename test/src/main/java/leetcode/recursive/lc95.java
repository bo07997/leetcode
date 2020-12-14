package leetcode.recursive;

import java.util.ArrayList;
import java.util.List;
import leetcode.recursive.TreeNode;
public class lc95 {


    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        return new_trees(1,n);
    }

    public List<TreeNode> new_trees(int start, int end){
        if (start>end||end==0){
            return new ArrayList<>();
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        if (end == start){
            treeNodes.add(new TreeNode(end));
            return treeNodes;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> lefts = new_trees(start,i-1);
            List<TreeNode> rights = new_trees(i+1,end);
            if (!lefts.isEmpty()&&!rights.isEmpty()){
                for (TreeNode left:lefts){
                    for (TreeNode right:rights){
                        TreeNode node = new TreeNode(i);
                        node.left =left;
                        node.right = right;
                        treeNodes.add(node);
                    }
                }
            } else if (lefts.isEmpty()){
                for (TreeNode right:rights){
                    TreeNode node = new TreeNode(i);
                    node.left =null;
                    node.right = right;
                    treeNodes.add(node);
                }
            } else {
                for (TreeNode left:lefts){
                    TreeNode node = new TreeNode(i);
                    node.left =left;
                    node.right = null;
                    treeNodes.add(node);
                }
            }

        }
        return treeNodes;
    }

}
