package com.stevesun.solutions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache(2);//capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
        */

/**
 * The shortest implementation is to use LinkedHashMap:
 * specify a size of the linkedHashMap;
 * override the removeEldestEntry method when its size exceeds max size: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-
 * in the constructor, set the last boolean variable to be true: it means the ordering mode, if we set it to be true, it means
 * in access order, false, means it's in insertion order: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-*/
public class _146_use_LinkedHashMap {
    
    private Map<Integer, Integer> cache;
    private final int max;
    
    public _146_use_LinkedHashMap(int capacity) {
        max = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true){
            public boolean removeEldestEntry(Map.Entry eldest){
                return cache.size() > max;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
    }
}