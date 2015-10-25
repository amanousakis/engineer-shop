package com.iri.aacommon.service.util.condition;

import org.springframework.beans.BeansException;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * The Class EnableCacheServiceCondition.
 *
 * This check is necessary for clients that depend upon aa-core and do not implement a caching scheme (i.e. m-web-app).
 * In this scenario the CacheService will not properly be instantiated in Spring Application Context because no
 * CacheManager is configured
 */
public class EnableCacheServiceCondition implements Condition {

	/** {@inheritDoc} */
	@Override
	public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {

		boolean matches = true;

		// First make sure that a bean with the wanted id exists
		if (context.getBeanFactory().containsBean("cacheManager")) {

			try {
				// and try to load it based on the expected class
				context.getBeanFactory().getBean(EhCacheCacheManager.class);
			} catch (final BeansException e) {
				matches = false;
			}
		} else {
			matches = false;
		}

		return matches;
	}

}
