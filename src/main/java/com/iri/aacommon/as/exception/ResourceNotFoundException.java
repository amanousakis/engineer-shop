package com.iri.aacommon.as.exception;

import com.iri.aacommon.enumeration.system.FaultId;
import com.iri.aacommon.exception.IriIOException;

/**
 * The Class ResourceNotFoundException. This exception is thrown when no domain object is found by a given primary key.
 */
public class ResourceNotFoundException extends IriIOException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -332424242444433287L;

	/**
	 * The fault id. This enumeration will give enable us to carry more specific information about the cause of this exception in more robust way than
	 * a message property.
	 */
	private FaultId faultId;

	/**
	 * Constructs the exception with the given exception message passed as parameter.
	 *
	 * @param errorMessage the reason for this {@link ResourceNotFoundException}.
	 */
	public ResourceNotFoundException(final String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Creates a new {@link ResourceNotFoundException} object using the given message and cause exception.
	 *
	 * @param message the reason for this {@link ResourceNotFoundException}
	 * @param cause the Throwable that caused this {@link ResourceNotFoundException}
	 */
	public ResourceNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new {@link ResourceNotFoundException} object using the given cause exception.
	 *
	 * @param cause the Throwable that caused this {@link ResourceNotFoundException}
	 */
	public ResourceNotFoundException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs the exception with the given exception message passed as parameter.
	 *
	 * @param errorMessage the reason for this {@link ResourceNotFoundException}.
	 * @param faultId the fault id, a more specific description of this exception's cause.
	 */
	public ResourceNotFoundException(final String errorMessage, final FaultId faultId) {
		super(errorMessage);
		this.faultId = faultId;
	}

	/**
	 * Creates a new {@link ResourceNotFoundException} object using the given message and cause exception.
	 *
	 * @param message the reason for this {@link ResourceNotFoundException}
	 * @param cause the Throwable that caused this {@link ResourceNotFoundException}
	 * @param faultId the fault id, a more specific description of this exception's cause.
	 */
	public ResourceNotFoundException(final String message, final Throwable cause, final FaultId faultId) {
		super(message, cause);
		this.faultId = faultId;
	}

	/**
	 * Creates a new {@link ResourceNotFoundException} object using the given cause exception.
	 *
	 * @param cause the Throwable that caused this {@link ResourceNotFoundException}
	 * @param faultId the fault id, a more specific description of this exception's cause.
	 */
	public ResourceNotFoundException(final Throwable cause, final FaultId faultId) {
		super(cause);
		this.faultId = faultId;
	}

	/**
	 * Gets the fault id.
	 *
	 * @return the fault id
	 */
	public FaultId getFaultId() {
		return faultId;
	}

	/**
	 * Gets the default fault id for this exception if none is assigned at throw time.
	 *
	 * @return the fault id
	 */
	public static FaultId getDefaultFaultId() {
		return FaultId.NO_RESOURCE_FOUND_BY_GIVEN_ID;
	}

}
