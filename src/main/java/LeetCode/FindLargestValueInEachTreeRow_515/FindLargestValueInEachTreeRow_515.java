package LeetCode.FindLargestValueInEachTreeRow_515;

import java.util.*;
import java.security.SecureRandom;

public class FindLargestValueInEachTreeRow_515 {


    public static void main(String[] args) {
        FindLargestValueInEachTreeRow_515 test = new FindLargestValueInEachTreeRow_515();

        System.out.print(test.solution_1(test.doMockTree(test.randomBigTree(15))));//nie dawac wiecej niz 16 pls
        //System.out.println(test.solution_1(test.doMockTree(new LinkedList<>(Arrays.asList(1, 3, 2, 5, 3, null, 9,1,2,8)))));


    }
    //Runtime ~ 2ms Beats 83%
    //Memory ~ 44 MB Beats 61%

    public List<Integer> solution_1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                maxValue = Math.max(maxValue, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            output.addLast(maxValue);

        }
        return output;
    }

    public TreeNode doMockTree(LinkedList<Integer> values) {
        if (values == null || values.isEmpty()) return null;
        TreeNode[] nodeArray = new TreeNode[values.size()];

        for (int i = 0; i < values.size(); i++) {
            Integer val = values.get(i);
            nodeArray[i] = val == null ? null : new TreeNode(val);
        }

        int mid = values.size() / 2 - 1;
        for (int i = 0; i <= mid; i++) {
            if (2 * i + 1 < values.size() && nodeArray[i * 2 + 1] != null) {
                assert nodeArray[i] != null;
                nodeArray[i].left = nodeArray[i * 2 + 1];
            }
            if (2 * i + 2 < values.size() && nodeArray[i * 2 + 2] != null) {
                assert nodeArray[i] != null;
                nodeArray[i].right = nodeArray[i * 2 + 2];
            }
        }
        return nodeArray[0];
    }

    public void printTree(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                assert node != null;
                System.out.print(STR." \{node.val}");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            System.out.println();
        }
    }
    public void printTreeWithIndentation(TreeNode root, String indent) {
        if (root == null)
            return;

        System.out.println(indent + root.val);
        printTreeWithIndentation(root.left, STR."\{indent}  ");
        printTreeWithIndentation(root.right, STR."\{indent}  ");
    }

    public LinkedList<Integer> randomBigTree(int lvl){
        SecureRandom rand = new SecureRandom();

        int valueOfAllLeaf = (int) Math.pow(2, lvl) - 1;

        LinkedList<Integer> randomArraylist = new LinkedList<Integer>();
        for (int i = 0; i < valueOfAllLeaf; i++) {
            int randval = rand.nextInt(10000);
            randomArraylist.add(randval);
        }

        return randomArraylist;
    }
}
