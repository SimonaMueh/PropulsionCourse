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

package domain;

public class Author {

	private final String name;
	private Book book;

	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		// Do NOT simply include this.book, because doing so will
		// invoke this.book.toString() which will result in
		// infinite recursion: StackOverflowError
		//
		// return "Author [name=" + this.name + ", book=" + this.book + "]";

		return "Author [name=" + this.name + ", book=" + (this.book == null ? "null" : this.book.getTitle()) + "]";
	}

}
