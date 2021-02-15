package spring.boot.cache.dao;

import spring.boot.cache.model.Book;

public interface Repo {
	
	Book dbGetByID(String id);
}
