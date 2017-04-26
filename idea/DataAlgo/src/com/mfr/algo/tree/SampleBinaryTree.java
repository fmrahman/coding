package com.mfr.algo.tree;

import java.util.Stack;

/**
 * Created by Farooq on 4/22/17.
 */
public class SampleBinaryTree {

    private BinaryTree root ;

    private void createBinaryTree () {

        int array [] = {90, 60, 70, 20, 100, 10, 50, 95, 250, 94, 97, 150, 300, 65, 75};
        for (int a : array) {
            root = addNode(root, a);
        }
    }

    private void inOrderTraversal (BinaryTree root) {
        if(root == null){
            return;
        }

        inOrderTraversal(root.leftTree);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rightTree);
    }

    private void preOrderTraversal (BinaryTree root) {
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal (root.leftTree);
        preOrderTraversal (root.rightTree);
    }

    private void postOrderTraversal (BinaryTree root) {
        if(root == null){
            return;
        }

        postOrderTraversal (root.leftTree);
        postOrderTraversal (root.rightTree);
        System.out.print(root.data + " ");
    }

    private BinaryTree addNode(BinaryTree root, int data) {
        if(root == null) {
            BinaryTree node = new BinaryTree();
            node.data = data;
            return node;
        }

        if(data < root.data) {
            root.leftTree = addNode(root.leftTree, data);
        } else if(data > root.data) {
            root.rightTree = addNode(root.rightTree, data);
        }
        return root;
    }


    private void zigzag(BinaryTree root) {

        Stack<BinaryTree> lst = new Stack<>();
        lst.push(root);
        Stack<BinaryTree> rst = new Stack<>();

        while (!lst.isEmpty() || !rst.isEmpty()) {

            while (!lst.isEmpty() ) {
                BinaryTree node = lst.pop();
                System.out.print(node.data + " ");

                rst.push(node.rightTree);
                rst.push(node.leftTree);
            }

            while (!rst.isEmpty()) {
                BinaryTree node = rst.pop();
                System.out.print(node.data + " ");
                lst.push(node.leftTree);
                lst.push(node.rightTree);
            }


        }


    }

    public static void main (String s[]) {

        SampleBinaryTree bst = new SampleBinaryTree();
        bst.createBinaryTree();
        System.out.println("inOrderTraversal:");
        bst.inOrderTraversal(bst.root);
        System.out.println("\npreOrderTraversal:");
        bst.preOrderTraversal(bst.root);
        System.out.println("\npostOrderTraversal:");
        bst.postOrderTraversal(bst.root);
        System.out.println("\nzigzag traversal");
        bst.zigzag(bst.root);
    }
}
