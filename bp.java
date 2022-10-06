package demo;
import java.io.*;
public class bp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 
		int n = 500;
        int ans = computeXor(n);
        System.out.println(ans);
		 
	}
	static int computeXor(int n){
        if(n == 0)
        	return 0; // base case
        int uni = 0;
        for (int i = 50; i <= n; i++) {
 
            uni = uni^i; // calculate XOR
        }
        return uni;
    }

}
