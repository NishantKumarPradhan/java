package recursion2;
import java.util.Scanner;
import java.util.ArrayList;

public class Permutation { // all possible permutation of the string's character
	
	public static ArrayList<String> permutation(String str){
		if (str.isEmpty()) {
			ArrayList<String> base = new ArrayList<>();
			base.add(" ");
			return base;
		}
		char c = str.charAt(0);
		String rs = str.substring(1);
		ArrayList<String> smallAns = permutation(rs);//got all P of bc now
		ArrayList<String> ans  = new ArrayList<>();// add a at all possible pos
		
		for (String elem : smallAns) {
			for (int i = 0; i < elem.length(); i++) {
				String v = elem.substring(0, i) + c + elem.substring(i);
				ans.add(v);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string:");
		String str = sc.nextLine();
		System.out.println(permutation(str));

	}

}
