package util;

public class Fibonacci {

	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(0));  // 0
		System.out.println(fibonacci(1));  // 1
		System.out.println(fibonacci(2));  // 1
		System.out.println(fibonacci(3));  // 2
		System.out.println(fibonacci(7));  // 13
		System.out.println(fibonacci(12)); // 144
	}
}


