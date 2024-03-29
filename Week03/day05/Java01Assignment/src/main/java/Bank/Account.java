package Bank;

public class Account {
	
	//fields
	protected final String id = java.util.UUID.randomUUID().toString();
	protected double balance;
	protected Customer customer;
	
	
	//constructor
	protected Account (Customer customer){
		this.balance = 0;
		this.customer = customer;
		customer.setAccount(this); // implement bidirectional relationship between customer and account
	}
	
	
	//getters and setters
	public String getId() {
		return id;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return this.customer;
	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//		customer.setAccount(this);
//	}


	//methods
	protected void credit (double amount){
		this.balance = this.balance + amount;
	}
	protected void debit (double amount){
		this.balance = this.balance -amount;
	}


	//toString
	@Override
	public String toString() {
		return "Account [id=" + this.id + ", balance=" + this.balance + ", customer=" + this.customer + "]";
	}



	

	
	
}