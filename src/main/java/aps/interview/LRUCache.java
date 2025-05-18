package aps.interview;

import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashMap 특징
// 1) 입력 순서 보장
// 2) get : O(1)
// 3) containsKey : O(1)
// 4) next : O(1)
// 5) null Key 허용

public class LRUCache {

	private final Map<Integer, Integer> cache;
	private final int capacity;

	public LRUCache(int capacity) {
		this.cache = new LinkedHashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			int value = cache.get(key);
			this.put(key, value);

			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		} else if (cache.size() == capacity) {
			Iterable<Integer> keySet = cache.keySet();
			int firstKey = keySet.iterator().next();
			cache.remove(firstKey);
		}

		cache.put(key, value);
	}

	public static void main(String[] args) {

		LRUCache lruCache = new LRUCache(3);

		lruCache.put(1, 1);
		System.out.println(lruCache.cache);

		lruCache.put(2, 2);
		System.out.println(lruCache.cache);

		lruCache.put(3, 3);
		System.out.println(lruCache.cache);

		lruCache.put(2, 4);
		System.out.println(lruCache.cache);

		int a = lruCache.get(1);
		System.out.println(a);
		System.out.println(lruCache.cache);

		int b = lruCache.get(2);
		System.out.println(b);
		System.out.println(lruCache.cache);


		lruCache.put(4, 4);
		System.out.println(lruCache.cache);

		lruCache.put(5, 5);
		System.out.println(lruCache.cache);
	}
}
