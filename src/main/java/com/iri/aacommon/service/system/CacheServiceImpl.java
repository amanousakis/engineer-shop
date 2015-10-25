package com.iri.aacommon.service.system;

import net.sf.ehcache.Cache;
import net.sf.ehcache.statistics.StatisticsGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import com.iri.aacommon.enumeration.system.CacheName;
import com.iri.aacommon.service.util.condition.EnableCacheServiceCondition;

/**
 * The type Cache service impl contains all cache related actions. In order to make use of this service your cache
 * manager needs to be named after cacheManager id.
 */
@Service
@Conditional(EnableCacheServiceCondition.class)
public class CacheServiceImpl implements CacheService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

	/** The Cache manager. */
	@Autowired
	private EhCacheCacheManager cacheManager;

	/** {@inheritDoc} */
	@Override
	public void evictAll() {
		final String[] cacheNames = this.cacheManager.getCacheManager().getCacheNames();
		this.evictCaches(cacheNames);
	}

	/** {@inheritDoc} */
	@Override
	public void evictCaches(final String[] cacheNames) {
		for (final String cacheName : cacheNames) {
			this.evictCache(CacheName.get(cacheName));
		}
	}

	/** {@inheritDoc} */
	@Override
	public void evictCache(final CacheName cacheName) {
		final Cache cache = this.cacheManager.getCacheManager().getCache(cacheName.getName());

		if (cache == null) {
			this.logger.warn("[cache:{}] is empty.", cacheName);
		} else {
			this.logger.debug("[cache:{}] removing {} members.", cacheName, cache.getSize());
			cache.removeAll();
			cache.flush();
			this.logger.warn("[cache:{}] evicted.", cacheName);
		}
	}

	/** {@inheritDoc} */
	@Override
	public String getStatistics() {
		final StringBuilder statistics = new StringBuilder();
		statistics.append("<u>Cache Statistics</u>");
		statistics.append("<br/>");
		statistics.append("Configuration: ");
		statistics.append("<br/>");
		statistics.append("Max Heap Size: ");
		statistics.append(this.cacheManager.getCacheManager().getConfiguration().getMaxBytesLocalHeapAsString());
		statistics.append("<br/>");
		statistics.append("Max Disk Size: ");
		statistics.append(this.cacheManager.getCacheManager().getConfiguration().getMaxBytesLocalDiskAsString());

		for (final CacheName cacheName : CacheName.values()) {
			final Cache cache = this.cacheManager.getCacheManager().getCache(cacheName.getName());
			if (cache != null) {
				statistics.append("<br/>");
				statistics.append("<br/>");
				final StatisticsGateway cacheStatistics = cache.getStatistics();
				statistics.append("Name: ");
				statistics.append(cacheName);
				statistics.append("<br/>");
				statistics.append("Heap Size: ");

				statistics.append(cacheStatistics.getLocalHeapSizeInBytes() / 1024);
				statistics.append("kb");
				statistics.append("<br/>");

				statistics.append("Disk Size: ");
				statistics.append(cacheStatistics.getLocalDiskSize() / 1024);
				statistics.append("kb");
				statistics.append("<br/>");
				statistics.append("Size: ");
				statistics.append(cacheStatistics.getSize());
				statistics.append("<br/>");
			}
		}
		return statistics.toString();
	}

	/** {@inheritDoc} */
	@Override
	public void evictCacheMembers(final CacheName cacheName, final String importId) {
		if (CacheName.ALL.equals(cacheName)) {
			for (final CacheName cName : CacheName.getSeverallyValues()) {
				this.evictCacheMembersInternal(cName, importId);
			}
		} else {
			this.evictCacheMembersInternal(cacheName, importId);
		}

	}

	/** {@inheritDoc} */
	@Override
	public String getContent(final CacheName cacheName) {
		final StringBuffer result = new StringBuffer();

		final Cache cache = this.cacheManager.getCacheManager().getCache(cacheName.getName());

		for (final Object key : cache.getKeys()) {
			result.append("key :").append(key).append(" ");
			result.append("value: ").append(cache.get(key).getObjectValue());
			result.append("<br/>");
		}

		return result.toString();
	}

	private void evictCacheMembersInternal(final CacheName cacheName, final String importId) {
		final Cache cache = this.cacheManager.getCacheManager().getCache(cacheName.getName());
		int counter = 0;
		if (cache == null || cache.getKeys().size() == 0) {
			this.logger.info("[importId:{}, cache:{}]. Is empty.", importId, cacheName);
		} else {
			for (final Object key : cache.getKeys()) {
				if (key.toString().length() > importId.length()) {
					if (importId.indexOf(key.toString().substring(0, importId.length())) == 0) {
						cache.remove(key);
						counter++;
					}
				}
			}
			if (counter > 0) {
				this.logger.info("[importId:{}, cache:{}, evictedMembers:{}]. Cache evicted.", new Object[] { importId, cacheName, counter });
			}
		}
	}
}
