package com.iri.aacommon.service.system;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.aacommon.exception.IriIOException;

/**
 * The Class ManifestServiceImpl.
 */
@Service
public class ManifestServiceImpl implements ManifestService {

	/** The context. */
	@Autowired
	ServletContext context;

	/** {@inheritDoc} */
	@Override
	public Attributes getManifestAttributes() throws IriIOException {

		final InputStream resourceAsStream = context.getResourceAsStream("/META-INF/MANIFEST.MF");
		final Manifest mf = new Manifest();

		try {
			mf.read(resourceAsStream);
		} catch (final IOException e) {
			throw new IriIOException(MessageFormat.format("Unable to open file {0}", resourceAsStream), e);
		}

		final Attributes attrs = mf.getMainAttributes();

		return attrs;
	}

}
