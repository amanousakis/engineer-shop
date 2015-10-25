package com.iri.aacommon.as.controller.system;

import java.text.MessageFormat;
import java.util.jar.Attributes;

import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iri.aacommon.controller.ancestors.AbstractController;
import com.iri.aacommon.domain.system.Response;
import com.iri.aacommon.enumeration.system.CacheName;
import com.iri.aacommon.exception.IriIOException;
import com.iri.aacommon.service.system.CacheService;
import com.iri.aacommon.service.system.ManifestService;

/**
 * The Class AnalyticServerCacheStatisticsController is responsible to accept and fulfill all analytic server requests
 * regarding cache, including cache statistics review and cache eviction.
 */
@RestController("AsSystemController")
@RequestMapping("/as")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemController extends AbstractController {

	/** The Constant MODULE_NAME used as PERF4J tag prefix. */
	private static String CACHE_EVICTED_HTML = "Cache {0} evicted";

	/** The cache service. */
	@Autowired
	private CacheService cacheService;

	/** The manifest service. */
	@Autowired
	private ManifestService manifestService;

	/**
	 * Gets the AS cache statistics.
	 *
	 * @return the AS cache statistics
	 */
	@RequestMapping(value = "cache/statistics", method = RequestMethod.GET)
	@Profiled(tag = "SystemController.getASCacheStatistics")
	public String getASCacheStatistics() {
		final String members = this.cacheService.getStatistics();
		return members;
	}

	/**
	 * Evict cache.
	 *
	 * @param cacheName the cache name
	 * @return the string
	 */
	@RequestMapping(value = "cache/evict/{cacheName}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@Profiled(tag = "SystemController.evictCache")
	public String evictCache(@PathVariable final String cacheName) {
		this.cacheService.evictCache(CacheName.get(cacheName));
		final String result = MessageFormat.format(CACHE_EVICTED_HTML, cacheName);
		return result;
	}

	/**
	 * Evict all caches.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "cache/evict", method = RequestMethod.GET)
	@Profiled(tag = "SystemController.evictAllCaches")
	public String evictAllCaches() {
		this.cacheService.evictAll();
		final String result = MessageFormat.format(CACHE_EVICTED_HTML, "ALL");
		return result;
	}

	/**
	 * Gets the content.
	 *
	 * @param cacheName the cache name
	 * @return the content
	 */
	@RequestMapping(value = "cache/content/{cacheName}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@Profiled(tag = "SystemController.getContent")
	public String getContent(@PathVariable final String cacheName) {
		final String cacheContent = this.cacheService.getContent(CacheName.get(cacheName));

		if (StringUtils.isEmpty(cacheContent)) {
			return "No content for cache: " + CacheName.get(cacheName);
		} else {
			return cacheContent;
		}
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 * @throws IriIOException the iri io exception
	 */
	@RequestMapping(value = "version", method = RequestMethod.GET)
	@Profiled(tag = "SystemController.getVersion")
	public Response<Attributes> getVersion() throws IriIOException {

		return new Response<Attributes>(this.manifestService.getManifestAttributes());
	}
}
