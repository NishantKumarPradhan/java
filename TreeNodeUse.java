package demo;
import java.util.Scanner;


public class TreeNodeUse {
	
	public static TreeNode<Integer> input(Scanner sc){
		System.out.println("enter data of the node:");
		int data = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		System.out.println("enter the no of children of node: " + data);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			TreeNode<Integer> child = input(sc);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String str = root.data + ": ";
		for (int i = 0; i < root.children.size(); i++) {
			if (i != root.children.size() - 1) {
				str = str + root.children.get(i).data + ", ";
			}
			else {
			    str = str + root.children.get(i).data;
		    }
		}
		
		System.out.println(str);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode<Integer> root = input(sc);
		print(root);


	}

}
