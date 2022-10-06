package demo;
import java.util.Scanner;
import java.util.ArrayList;
public class SubSequences {

	public static ArrayList<String> solve(String str) {
		if (str.isEmpty()) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		Scanner sc = new Scanner(System.in);
		ArrayList<String> smallAns = solve(str.substring(1));
		ArrayList<String> ans = new ArrayList<String>();
		for (int i = 0; i < smallAns.size(); i++) {
			ans.add(smallAns.get(i));
			ans.add(str.charAt(0) + smallAns.get(i));
		}
		return ans;
		   
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enyter a String:");
		String str = sc.nextLine();
		System.out.println(solve(str));
	}
	
}
