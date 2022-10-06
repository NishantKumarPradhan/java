package demo;

import java.util.ArrayList;

public class permu {
	
	public static ArrayList<String> permut(String str){
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add(" ");
			return base;
		}
		char c = str.charAt(0);
		String rs = str.substring(1);
		ArrayList<String> smallAns = permut(rs);//got all P of bc now
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
		System.out.println(permut("abc"));

	}

}
