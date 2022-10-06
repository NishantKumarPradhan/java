package demo;

class D{
	D() {
		System.out.println("hello I am D");
	}
}

class C extends D{
	C() {
		System.out.println("hello I am C");
	}
}

public class Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C d = new C();

	}

}
