package exercises;

public class Hello {
	public static void main(String... args) { // ...-> from 0 to n Elements in the Array
		if (args.length == 0){  // array -> .length list -> .size
			System.out.println("Hello, Unknown!");
		}
		System.out.println(args);
		for (String name:args){
			System.out.format("Hello  %s!\n", name);	
		}
		String name1 = " Luke Skywalker      ";
		System.out.println(name1.trim());
		System.out.println(name1);
	}
}




