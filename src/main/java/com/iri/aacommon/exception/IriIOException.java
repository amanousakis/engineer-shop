package com.iri.aacommon.exception;

/** IriIOException serves as an exception for I/O errors. */
public class IriIOException extends IriException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4264859793320082764L;

	/** Instantiates a new {@link IriIOException}. */
	public IriIOException() {
		super();
	}

	/**
	 * Instantiates a new {@link IriIOException}.
	 *
	 * @param message the message
	 */
	public IriIOException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link IriIOException}.
	 *
	 * @param cause the cause
	 */
	public IriIOException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new {@link IriIOException}.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IriIOException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new {@link IriIOException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 */
	public IriIOException(final String message, final Long faultReasonId) {
		super(message, faultReasonId);
	}

	/**
	 * Instantiates a new {@link IriIOException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 * @param cause the cause
	 */
	public IriIOException(final String message, final Long faultReasonId, final Throwable cause) {
		super(message, faultReasonId, cause);
	}
}
