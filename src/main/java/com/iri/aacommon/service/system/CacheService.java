package com.iri.aacommon.service.system;

import com.iri.aacommon.enumeration.system.CacheName;

/** The interface Cache service contains all cache related actions. */
public interface CacheService {

	/** Clear all system caches. */
	void evictAll();

	/**
	 * Evict the caches of the given {@link String[] cacheNames}. In case the given cacheNames are empty, evicts all
	 * caches
	 *
	 * @param cacheNames the caches to evict
	 */
	void evictCaches(String[] cacheNames);

	/**
	 * Clear the cache of the given {@link CacheName}.
	 *
	 * @param cacheName the cache name to evict
	 */
	void evictCache(CacheName cacheName);

	/**
	 * Retrieves cache statistics at HTML format. This contains the cache configuration settings along with cache size
	 * per {@link CacheName}.
	 *
	 * @return the statistics
	 */
	String getStatistics();

	/**
	 * Clear the members of a specific cache based on the import id.
	 *
	 * @param cacheName the cache name the member exists
	 * @param importId the target key to be evicted
	 */
	void evictCacheMembers(CacheName cacheName, String importId);

	/**
	 * Gets the content of a specific cache.
	 *
	 * @param cacheName the cache name
	 * @return the content
	 */
	String getContent(CacheName cacheName);

}
