package com.iri.aacommon.enumeration.system;

import java.util.ArrayList;
import java.util.List;

/**
 * This enumeration contains all possible cache names.
 */
public enum CacheName {

	/** The all. */
	ALL("all"),

	/** The system. */
	SYSTEM("system"),

	/** The ascalls. */
	ASCALLS("asCalls"),

	/** The cdm. */
	CDM("cdm"),

	/** The vmfiles. */
	VMFILES("vmFiles"),

	/** The META db. */
	META("meta");

	/**
	 * The Name.
	 */
	private final String name;

	/**
	 * Instantiates a new Cache.
	 *
	 * @param name the name
	 */
	CacheName(final String name) {
		this.name = name;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get cache.
	 *
	 * @param name the name
	 * @return the cache
	 */
	public static CacheName get(final String name) {
		for (final CacheName cache : CacheName.values()) {
			if (cache.getName().equals(name)) {
				return cache;
			}
		}
		return null;
	}

	/**
	 * Gets all {@link com.iri.aacommon.enumeration.system.CacheName cache names} except
	 * {@link com.iri.aacommon.enumeration.system.CacheName All}
	 *
	 * @return {@link java.util.List list of} {@link com.iri.aacommon.enumeration.system.CacheName cache names}
	 */
	public static List<CacheName> getSeverallyValues() {
		final List<CacheName> cacheNames = new ArrayList<CacheName>();
		for (final CacheName cache : CacheName.values()) {
			if (!cache.equals(CacheName.ALL)) {
				cacheNames.add(cache);
			}
		}
		return cacheNames;
	}
}
