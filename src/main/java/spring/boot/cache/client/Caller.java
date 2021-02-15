package spring.boot.cache.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.boot.cache.dao.Repo;

@Component
public class Caller implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Caller.class);
	
	private final Repo repo;
	
	
	public Caller(Repo repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {

		LOGGER.info("ID 1 -> {}", repo.dbGetByID("1"));
		LOGGER.info("ID 1 cache proof -> {}", repo.dbGetByID("1"));
		
		LOGGER.info("ID 2 -> {}", repo.dbGetByID("2"));
		LOGGER.info("ID 2 cache proof -> {}", repo.dbGetByID("2"));
		
		LOGGER.info("ID 5 -> {}", repo.dbGetByID("5"));
		LOGGER.info("ID 5 cache proof -> {}", repo.dbGetByID("5"));
	}

}
