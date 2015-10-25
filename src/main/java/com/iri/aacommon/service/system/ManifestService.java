package com.iri.aacommon.service.system;

import java.util.jar.Attributes;

import com.iri.aacommon.exception.IriIOException;

/**
 * The Interface ManifestService.
 */
public interface ManifestService {

	/**
	 * Gets the manifest attributes. The Service assumes that a file exists on path META-INF/MANIFEST.MF
	 *
	 * @return the manifest attributes
	 * @throws IriIOException the iri io exception
	 */
	Attributes getManifestAttributes() throws IriIOException;

}
