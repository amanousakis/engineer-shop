package com.iri.aacommon.exception;

/** IriAuthenticationException serves as generic exception for Authentication errors. Parent exception of all authentication exceptions. */
public class IriAuthenticationException extends IriException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Instantiates a new {@link IriAuthenticationException}. */
	public IriAuthenticationException() {
		super();
	}

	/**
	 * Instantiates a new {@link IriAuthenticationException}.
	 *
	 * @param message the message
	 */
	public IriAuthenticationException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link IriAuthenticationException}.
	 *
	 * @param cause the cause
	 */
	public IriAuthenticationException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new {@link IriAuthenticationException}.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IriAuthenticationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new {@link IriAuthenticationException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 */
	public IriAuthenticationException(final String message, final Long faultReasonId) {
		super(message, faultReasonId);
	}

	/**
	 * Instantiates a new {@link IriAuthenticationException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 * @param cause the cause
	 */
	public IriAuthenticationException(final String message, final Long faultReasonId, final Throwable cause) {
		super(message, faultReasonId, cause);
	}
}
