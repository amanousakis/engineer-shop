package com.iri.aacommon.exception;

/** IriValidationException serves as generic exception for validation errors. Parent exception of all validation exceptions. */
public class IriValidationException extends IriException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4264859793320082764L;

	/** Instantiates a new {@link IriValidationException}. */
	public IriValidationException() {
		super();
	}

	/**
	 * Instantiates a new {@link IriValidationException}.
	 *
	 * @param message the message
	 */
	public IriValidationException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link IriValidationException}.
	 *
	 * @param cause the cause
	 */
	public IriValidationException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new {@link IriValidationException}.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IriValidationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new {@link IriValidationException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 */
	public IriValidationException(final String message, final Long faultReasonId) {
		super(message, faultReasonId);
	}

	/**
	 * Instantiates a new {@link IriValidationException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 * @param cause the cause
	 */
	public IriValidationException(final String message, final Long faultReasonId, final Throwable cause) {
		super(message, faultReasonId, cause);
	}
}
