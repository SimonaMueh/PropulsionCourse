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

package math;

// import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {

	// JUL:
	// private static final Logger logger = Logger.getLogger(Fibonacci.class.getName());

	// Log4J:
	private static final Logger logger = LogManager.getLogger(Fibonacci.class);

	static int fibonacci(int n) {
		// JUL:
		// FYI: logging information like this as INFO level is a *bad idea*.
		// logger.info(() -> "Computing fibonnaci(" + n + ")");

		// Log4J:
		logger.trace(() -> "Computing fibonnaci(" + n + ")");

		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		//		System.out.println(fibonacci(0)); // 0
		//		System.out.println(fibonacci(1)); // 1
		//		System.out.println(fibonacci(2)); // 1
		//		System.out.println(fibonacci(3)); // 2
		//		System.out.println(fibonacci(7)); // 13
		System.out.println(fibonacci(12)); // 144
	}

}
