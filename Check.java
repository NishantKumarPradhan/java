package demo;

import java.util.ArrayList;

public class Check {
	
	public static ArrayList<String> permutation(String str){
		if (str.isEmpty()) {
			ArrayList<String> base = new ArrayList<>();
			base.add(" ");
			return base;
		}
		char c = str.charAt(0);
		String rs = str.substring(1);
		ArrayList<String> smallAns = permutation(rs);
		ArrayList<String> ans  = new ArrayList<>();
		
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
		System.out.println("hello");
		System.out.println(permutation("abc"));

	}

}
