package com.iri.aacommon.exception;


/**
 * The Class IriAnalyticServerException. Analytic Server generic exception. Used to group different exception cases under one and handled accordingly.
 */
public class IriAnalyticServerException extends IriException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3578246441514980253L;

	/**
	 * Constructs the exception with the given exception message passed as parameter.
	 *
	 * @param errorMessage the reason for this {@link IriAnalyticServerException}.
	 */
	public IriAnalyticServerException(final String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Creates a new {@link IriAnalyticServerException} object using the given message and cause exception.
	 *
	 * @param message the reason for this {@link IriAnalyticServerException}
	 * @param cause the Throwable that caused this {@link IriAnalyticServerException}
	 */
	public IriAnalyticServerException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new {@link IriAnalyticServerException} object using the cause exception.
	 *
	 * @param cause the Throwable that caused this {@link IriAnalyticServerException}
	 */
	public IriAnalyticServerException(final Throwable cause) {
		super(cause);
	}
}
