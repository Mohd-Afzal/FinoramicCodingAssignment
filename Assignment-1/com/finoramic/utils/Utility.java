package com.finoramic.utils;

import java.util.Scanner;

public class Utility {

	public static TreeNode<Integer> takeInput(){
		
		Queue<TreeNode<Integer>> pN = new Queue<>();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the root data");
		int rootData = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(rootData);
		pN.enqueue(root);
		
		while(!pN.isEmpty()) {
			TreeNode<Integer> front = pN.dequeue();
			
			System.out.println("Enter the leftChild for " + front.data);
			int leftData = s.nextInt();
			if(leftData != -1) {
				TreeNode<Integer> leftNode = new TreeNode<Integer>(leftData);
				front.left = leftNode;
				pN.enqueue(leftNode);
			}
			System.out.println("Enter the rightChild for " + front.data);
			int rightData = s.nextInt();
			if(rightData != -1) {
				TreeNode<Integer> rightNode = new TreeNode<Integer>(rightData);
				front.right = rightNode;
				pN.enqueue(rightNode);
			}
			
		}
		s.close();
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		
		Queue<TreeNode<Integer>> q = new Queue<>();
		
		q.enqueue(root);
		q.enqueue(null);
		
		while(!q.isEmpty()) {
			
			TreeNode<Integer> front = q.dequeue();
			
			if(front == null) {
				if(q.size() == 0) {
					break;
				}
				q.enqueue(null);
				System.out.println();
				continue;
			}
		
			System.out.print(front.data + " ");
			
			if(front.left != null)
				q.enqueue(front.left);
			if(front.right != null)
				q.enqueue(front.right);
			
		}
		
	}

}
