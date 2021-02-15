package spring.boot.cache.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import spring.boot.cache.model.Book;

@Component
public class DummyRepository implements Repo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DummyRepository.class);

	@Override
	@Cacheable(cacheNames = {"cache-book"}, key = "#id", 
	condition = "T(spring.boot.cache.logic.CacheLogic).minorThan5(#id)")//without vendor cache is simply a ConcurrentHashMap
	public Book dbGetByID(String id){

		simulateDBDelay();//This delay must occur only if record is not in cache
		Book ret = new Book(id, "title");
		
		return ret;
	}

	private void simulateDBDelay() {
		try {
			LOGGER.info("Fetch from DB ...");
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
