/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bank.service;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import bank.config.BankConfig;
import bank.domain.Account;
import bank.domain.Customer;
import config.MessageServiceConfig;
import config.TestMailConfig;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BankConfig.class )
@ActiveProfiles
public class BankServiceTests {

//	private final BankService bankService = new BankService();
	
	@Autowired
	BankService bankService;

	private final Customer customer1 = new Customer("John Doe");
	private final Customer customer2 = new Customer("Jane Doe");

	private final Account account1 = new Account(customer1, 1000);
	private final Account account2 = new Account(customer2, 2000);

	@Before
	public void verifyInitialState() {
		assertNoCustomers();
	}
	
	@After
	public void verifyUltimateState() {
		deleteCustomer();
			bankService.delete(customer1.getId());
			bankService.delete(customer2.getId());
			assertNumCustomers(0);
	}
	
	@Test
	public void saveCustomer() {
		bankService.save(customer1);
		assertNumCustomers(1);
		bankService.save(customer2);
		assertNumCustomers(2);
	}

	@Test
	public void deleteCustomer() {
		saveTwoCustomers();
		bankService.delete(customer1.getId());
		assertNumCustomers(1);

		Customer retrievedCustomer = bankService.findById(customer1.getId());
		assertNull(retrievedCustomer);

		retrievedCustomer = bankService.findById(customer2.getId());
		assertNotNull(retrievedCustomer);
	}

	@Test
	public void findCustomerById() {
		bankService.save(customer1);
		assertNumCustomers(1);
		Customer retrievedCustomer = bankService.findById(customer1.getId());
		assertThat(retrievedCustomer).isNotNull();
		assertThat(retrievedCustomer).isEqualTo(customer1);
	}

	@Test
	public void findNonexistentCustomerById() {
		Customer retrievedCustomer = bankService.findById("bogus ID");
		assertThat(retrievedCustomer).isNull();
	}

	@Test
	public void findAllCustomers() {
		saveTwoCustomers();
		List<Customer> customers = bankService.findAll();
		assertThat(customers).containsExactlyInAnyOrder(customer1, customer2);

		// Uncomment the following to see the results of Customer#toString()
		// and Account#toString()
		// System.out.println(customers);
	}

	@Test
	public void verifyThatAllSavedCustomersHaveAccounts() {
		saveTwoCustomers();
		List<Customer> customers = bankService.findAll();

		// Get accounts of all customers manually (without Java 8 streams)
		//
		//		List<Account> accounts = new ArrayList<>();
		//		for (Customer customer : customers) {
		//			accounts.add(customer.getAccount());
		//		}

		// Get accounts of all customers using Java 8 streams
		//
		// @formatter:off
		List<Account> accounts = customers.stream()
				.map(Customer::getAccount)
				.collect(toList());
		// @formatter:on

		assertThat(accounts).containsExactlyInAnyOrder(account1, account2);
	}

	private void saveTwoCustomers() {
		bankService.save(customer1);
		bankService.save(customer2);
		assertNumCustomers(2);
	}

	private void assertNoCustomers() {
		assertNumCustomers(0);
	}

	private void assertNumCustomers(int expected) {
		assertThat(bankService.findAll()).hasSize(expected);
	}

}
