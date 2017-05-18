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

package password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StrongPasswordValidatorTests {

	private final PasswordValidator validator = new StrongPasswordValidator();

	@Test
	public void isValid() {
		assertThat(validator.isValid(null)).isFalse();
		assertThat(validator.isValid("pswd")).isFalse();
		assertThat(validator.isValid("12345678")).isFalse();
		assertThat(validator.isValid("123456789")).isFalse();
		assertThat(validator.isValid("abcdefghi")).isFalse();

		assertThat(validator.isValid("abcdefgh9")).isTrue();
		assertThat(validator.isValid("12345678A")).isTrue();
	}

}
