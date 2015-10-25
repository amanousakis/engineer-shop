package com.iri.aacommon.exception;

/** IriException serves as generic exception for data errors. Basic parent exception group all descendant data-related exceptions. */
public class IriConfigurationException extends IriException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4264859793320082764L;

	/** Instantiates a new {@link IriConfigurationException}. */
	public IriConfigurationException() {
		super();
	}

	/**
	 * Instantiates a new {@link IriConfigurationException}.
	 *
	 * @param message the message
	 */
	public IriConfigurationException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link IriConfigurationException}.
	 *
	 * @param cause the cause
	 */
	public IriConfigurationException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new {@link IriConfigurationException}.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IriConfigurationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new {@link IriConfigurationException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 */
	public IriConfigurationException(final String message, final Long faultReasonId) {
		super(message, faultReasonId);
	}

	/**
	 * Instantiates a new {@link IriConfigurationException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 * @param cause the cause
	 */
	public IriConfigurationException(final String message, final Long faultReasonId, final Throwable cause) {
		super(message, faultReasonId, cause);
	}
}
