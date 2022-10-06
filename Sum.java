package demo;
import java.util.HashMap;

public class Sum {
	
	public static int check(char input1[], char input2[]) {
		
		int ab[] = new int[123];
		
		for (int i = 0; i < input1.length; i++) {
			int a = (int) input1[i];
			ab[a] = ab[a] + 1;
		}
		
		for (int i = 0; i < input2.length; i++) {
			int a = (int) input2[i];
			ab[a] = ab[a] + 1;
		}
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			if (ab[i] == 1) {
				sum = sum + i;
			}
		}
	//	return sum;
		int result = 0;
		for (int i = sum; i != 0; i = i/10) {
			result = result + i % 10;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a[] = {'G', 'Q','R'};
		char b[] = {'R', 'T','U'};
		
		System.out.println(check(a, b));

	}

}
