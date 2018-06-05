package main;

import java.util.ArrayList;
import java.util.Scanner;

import com.finoramic.utils.*;

public class BinaryTree {
	
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode<Integer> root, int sum, ArrayList<Integer> path) {
		
		if(root == null) {
			return new ArrayList<>();
		}
		
		if(root.left == null && root.right == null) {
			
			ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
			
			if(root.data == sum) {
				path.add(root.data);
				paths.add(path);
				
				return paths;
			} else {
				return paths;
			}
			
		}
		
		ArrayList<Integer> leftPath = new ArrayList<>();
		ArrayList<Integer> rightPath = new ArrayList<>();
		
		for(int data : path) {
			leftPath.add(data);
			rightPath.add(data);
		}
		
		leftPath.add(root.data);
		rightPath.add(root.data);
		
		ArrayList<ArrayList<Integer>> leftPaths = pathSum(root.left, sum - root.data, leftPath);
		
		ArrayList<ArrayList<Integer>> rightPaths = pathSum(root.right, sum - root.data, rightPath);
		
		ArrayList<ArrayList<Integer>> finalPaths = new ArrayList<>();
		
		for(ArrayList<Integer> pat : leftPaths) {
			finalPaths.add(pat);
		}
		
		for(ArrayList<Integer> pat : rightPaths) {
			finalPaths.add(pat);
		}
		
		return finalPaths;
		
	}
	
	public static void main(String[] args) {
		
		//Test cases :
		//1 1 3 1 1 1 2 1 -1 2 3 -1 1 -1 -1 2 -1 -1 1 -1 -1 -1 -1 -1 -1 -1 -1, sum 6
		//2 3 2 1 -1 2 -1 -1 -1 -1 -1, sum 6
		TreeNode<Integer> root = Utility.takeInput();
		Utility.printLevelWise(root);
		
		Scanner s = new Scanner(System.in);
		int sum = s.nextInt();
		s.close();
		
		ArrayList<ArrayList<Integer>> list = pathSum(root, sum, new ArrayList<>());
		
		System.out.println();
		
		for(ArrayList<Integer> innerList : list) {
			System.out.println(innerList);
		}
		
	}

}
