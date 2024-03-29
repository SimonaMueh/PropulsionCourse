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

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Customer {

	private static final AtomicInteger idGenerator = new AtomicInteger();

	private final String id = String.valueOf(idGenerator.incrementAndGet());
	private final String name;
	private Account account;

	/**
	 * Create a new {@code Customer} without an {@link Account}.
	 */
	public Customer(String name) {
		this.name = name;
	}

	/**
	 * Create a new {@code Customer} with an {@link Account}
	 * with the supplied initial balance.
	 */
	public Customer(String name, double accountBalance) {
		this(name);
		this.account = new Account(this, accountBalance);
	}

}
