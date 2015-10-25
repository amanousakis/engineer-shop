package com.iri.aacommon.controller.ancestors;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerMapping;

import com.iri.aacommon.domain.builder.FaultBuilder;
import com.iri.aacommon.domain.system.Fault;
import com.iri.aacommon.domain.system.Response;
import com.iri.aacommon.enumeration.system.FaultId;
import com.iri.aacommon.exception.IriAnalyticServerException;
import com.iri.aacommon.exception.IriAuthenticationException;
import com.iri.aacommon.exception.IriConfigurationException;
import com.iri.aacommon.exception.IriDataException;
import com.iri.aacommon.exception.IriException;
import com.iri.aacommon.exception.IriIOException;
import com.iri.aacommon.exception.IriValidationException;

/**
 * The Class AbstractController contains common controller behavior that applies to every other controller like exception handling.
 */
public abstract class AbstractController {

	/** The Constant logger. */
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/** The message source. */
	@Autowired
	protected MessageSource messageSource;

	/**
	 * Handle all types of IRI checked exceptions {@link IriException}.
	 *
	 * @param exception the parent of all IRI checked exceptions {@link IriException}.
	 * @param request the request of type {@link HttpServletRequest}.
	 * @return the {@link Response} object which includes our error response we communicate to the client.
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler({ IriException.class })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Response handleIriException(final IriException exception, final HttpServletRequest request) {

		LOG.error(
				MessageFormat.format("Iri exception occured: [name={0}, RequestParams={1}, Error message={2}",
						new Object[] { exception.getClass().getSimpleName(), request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE), exception.getMessage() }), exception);

		return new Response(assembleFaultForIriException(exception));
	}

	/**
	 * Handle unchecked exceptions {@link Exception}.
	 *
	 * @param exception the unchecked exception {@link Exception}.
	 * @param request the request of type {@link HttpServletRequest}.
	 * @return the {@link Response} object which includes our error response we communicate to the client.
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Response handleUncheckedException(final Exception exception, final HttpServletRequest request) {

		LOG.error(
				MessageFormat.format("Unchecked exception occured: [name={0}, RequestParams={1}, Error message={2}",
						new Object[] { exception.getClass().getSimpleName(), request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE), exception.getMessage() }), exception);

		return new Response(assembleFaultForUncheckedException(exception));
	}

	/**
	 * Binds IRI checked exceptions to rest service response by creating a {@link Fault} object with the appropriate error code/message depending on
	 * the exception received.
	 *
	 * @param exception the IRI checked exception.
	 * @return the fault
	 */
	private Fault assembleFaultForIriException(final IriException exception) {

		FaultId faultId = FaultId.GENERAL_IRI_ERROR;

		/* IriAnalyticServerException triggered by a problem occurred in the interaction with AS. */
		if (exception instanceof IriAnalyticServerException)
			faultId = FaultId.ANALYTIC_SERVER_ERROR;

		/* IriDataException triggered by data base operation error. */
		if (exception instanceof IriDataException)
			faultId = FaultId.DATABASE_ERROR;

		/* IriIOException triggered by I/O operation error. */
		if (exception instanceof IriIOException)
			faultId = FaultId.IO_ERROR;

		/* IriConfigurationException triggered by configuration error. */
		if (exception instanceof IriConfigurationException)
			faultId = FaultId.CONFIGURATION_ERROR;

		/* IriValidationException triggered by I/O operation error. */
		if (exception instanceof IriValidationException)
			faultId = FaultId.GENERAL_VALIDATION_ERROR;

		/* IriAuthenticationException triggered by I/O operation error. */
		if (exception instanceof IriAuthenticationException)
			faultId = FaultId.AUTHENTICATION_ERROR;

		return assembleFault(faultId, exception.getMessage());
	}

	/**
	 * Binds unchecked exceptions to rest service response by creating a {@link Fault} object with the default error code/message.
	 *
	 * @param exception the unchecked exception.
	 * @return the fault
	 */
	private Fault assembleFaultForUncheckedException(final Exception exception) {

		return assembleFault(FaultId.GENERAL_LOGICAL_ERROR, exception.getMessage());
	}

	/**
	 * Assemble fault.
	 *
	 * @param faultId the fault id
	 * @param faultDescription the fault description
	 * @return the fault
	 */
	private Fault assembleFault(final FaultId faultId, final String faultDescription) {

		return new FaultBuilder().withFaultId(faultId.getIdRef()).withFaultCode(faultId.getFaultCode().getName()).withFaultDescription(faultDescription).build();
	}
}
