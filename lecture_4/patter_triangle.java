package lecture_4;

import java.util.Scanner;

public class patter_triangle {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int i=1,n;
		System.out.println("Enter the no of rows ");
		n =sc.nextInt();
		
		while(i<=n) {
			int j=1;int t=i; //mast logic
			while(j<=i) {
				
				System.out.print(+t);
				j++;
				t++;
			}
			System.out.println();
			i++;
	}

	}

}
