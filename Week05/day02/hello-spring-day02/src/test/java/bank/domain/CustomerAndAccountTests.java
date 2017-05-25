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

package bank.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CustomerAndAccountTests {

	@Test
	public void standardConstructors() {
		Customer customer = new Customer("John Smith");
		Account account = new Account(customer, 1000);

		// Assert bidirectional relationship
		assertThat(customer.getAccount()).isEqualTo(account);
		assertThat(account.getCustomer()).isEqualTo(customer);
	}

	@Test
	public void simplifiedConstructor() {
		Customer customer = new Customer("John Smith", 1000);
		Account account = customer.getAccount();
		assertThat(account).isNotNull();

		// Assert bidirectional relationship
		assertThat(customer.getAccount()).isEqualTo(account);
		assertThat(account.getCustomer()).isEqualTo(customer);
	}

	@Test
	public void testToString() {
		Customer customer = new Customer("John Smith", 1000);
		Account account = customer.getAccount();

		assertThat(customer.toString()).contains("John Smith", account.getId());
		assertThat(account.toString()).contains(account.getId(), customer.getId());
	}

}
