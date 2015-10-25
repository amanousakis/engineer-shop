package com.iri.aacommon.exception;

/** IriException is used to group different exception cases under one and handled accordingly. */
public class IriException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2116596954612674302L;

	/** The fault reason id. */
	private Long faultReasonId;

	/** Instantiates a new {@link IriException}. */
	public IriException() {
		super();
	}

	/**
	 * Instantiates a new {@link IriException}.
	 *
	 * @param message the message
	 */
	public IriException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new {@link IriException}.
	 *
	 * @param cause the cause
	 */
	public IriException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new {@link IriException}.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IriException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new {@link IriException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 */
	public IriException(final String message, final Long faultReasonId) {
		super(message);
		this.faultReasonId = faultReasonId;
	}

	/**
	 * Instantiates a new {@link IriException}.
	 *
	 * @param message the message
	 * @param faultReasonId the fault reason id
	 * @param cause the cause
	 */
	public IriException(final String message, final Long faultReasonId, final Throwable cause) {
		super(message, cause);
		this.faultReasonId = faultReasonId;
	}

	/**
	 * Gets the fault reason id.
	 *
	 * @return the fault reason id
	 */
	public Long getFaultReasonId() {
		return faultReasonId;
	}
}
