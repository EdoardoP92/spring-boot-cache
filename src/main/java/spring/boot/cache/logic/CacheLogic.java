package spring.boot.cache.logic;

public class CacheLogic {

	public static Boolean minorThan5(String id) {

		boolean ret = Integer.valueOf(id) < 5;
		
		return ret;
	}
}
