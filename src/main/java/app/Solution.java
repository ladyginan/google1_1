package app;

import java.util.*;

public class Solution {

    public static int[] solution(int high, int[] ints) {
        int elementsNumber = (int) Math.pow(2, high) - 1;
        int[] dummyData = new int[elementsNumber];
        int dummyNumber = 1;
        for (int i = 0; i < elementsNumber; i++) {
            dummyData[i] = dummyNumber;
            dummyNumber++;
        }

        Tree tree = new Tree(elementsNumber);
        tree.root = tree.postorderTraversal(dummyData, 0);
        List<Integer> result = tree.returnResult();

        return findConverterNumbers(ints, elementsNumber, result);

    }

    private static int[] findConverterNumbers(int[] ints, int elementsNumber, List<Integer> trResult) {
        List<Integer> convertersNumber = new ArrayList<>();
        for (int number : ints) {
            if (number == elementsNumber) {
                convertersNumber.add(-1);
                continue;
            }
            Integer integer = trResult.get(number);
            int parent = (int) Math.floor(integer - 1) / 2;
            int parentResult = trResult.indexOf(parent);
            convertersNumber.add(parentResult);
        }
        return convertersNumber.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Tree {
        Node root;
        List<Integer> result;

        public Tree(int elementNumber) {
            this.result = new ArrayList<>();
            result.add(elementNumber);
        }

        public Node postorderTraversal(int[] array, int i) {
            Node root = null;
            if (i < array.length) {
                root = new Node(array[i]);
                root.left = postorderTraversal(array, 2 * i + 1);
                root.right = postorderTraversal(array, 2 * i + 2);
                result.add(i);
            }
            return root;
        }

        public List<Integer> returnResult() {
            return result;
        }
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
