package Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerAccountDemo {
	public static void main(String[] args) {
		Customer cs = new Customer("Anna");
		Account ac = new Account(cs);
		//ac.setCustomer(cs);
		//cs.setAccount(ac);
		
		BankService myBankService = new BankService();
		
		myBankService.save(cs);
		myBankService.printAll();
		
//		System.out.println(cs);
//		System.out.println(ac);
//		System.out.println("Simona".hashCode());
//		System.out.println("Simona".hashCode());
//		System.out.println("Simona".hashCode());
		
		System.out.println("Please enter a name and press return:");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		System.out.println("you entered: " + userInput);
		Customer customer01 = new Customer(userInput);
		Account account01 = new Account(customer01);
		myBankService.save(customer01);
		myBankService.printAll();
		
//		try {
//			FileWriter fileWriter = new FileWriter("");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//fileWriter.write(str);
	}

}
