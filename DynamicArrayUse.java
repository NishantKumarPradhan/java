package demo;

public class DynamicArrayUse {
	public static void main(String[] args) {
		
		   Dynamic_Array d = new  Dynamic_Array();
		      for(int i = 0; i < 8; i++) {
			       d.add(i+1);
		      }
		        //System.out.println(d.size());
		        d.set(3, 4);
		        System.out.println(d.size());
	}
}
