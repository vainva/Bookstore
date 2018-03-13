package com.valtteri.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.valtteri.Bookstore.bean.Book;
import com.valtteri.Bookstore.bean.User;
import com.valtteri.Bookstore.repository.BookRepository;
import com.valtteri.Bookstore.repository.UserRepository;

@SpringBootApplication
@EnableScheduling
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStoreDemo(BookRepository repository, UserRepository userRepository) {
		return (args) -> {
			repository.save(new Book("For Whom the Bell Tolls", "Ernest Hemingway", "1940", "001"));
			repository.save(new Book("The Lord of the Rings: The Two Towers", "J.R.R Tolkien", "1954", "002"));
			repository.save(new Book("A Tale of Two Cities", "Charles Dickens", "1859", "003"));
		

			userRepository.save(new User("admin", "admin@email.com", "$2a$04$AHOikQYc5uJktr5fAsUJ/OGij0Ynyc0BflJx8x1FzhjLMzwUf3aV2", "ADMIN"));
			userRepository.save(new User("user", "user@email.com", "$2a$04$OifAo4rr3hM2nFZxM9dqvOY6oczXZbMFhEvNzZ5fionduVBlJXqVK", "USER"));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
