package com.iri.aacommon.enumeration.system;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The Enum FaultId contains unique fault id per business case/action. The idea is to group under this id, all errors being thrown for a specific
 * service method. Keep in mind that {@link FaultCode} proposes a specific range of ids per fault code.
 */
public enum FaultId {

	/* General Errors */
	/** Triggered when one or more components of the platform is not working as should be. */
	GENERAL_IRI_ERROR(1L, FaultCode.GENERAL_ERROR),

	/** Triggered when an error occurs in the AS invocation process. */
	ANALYTIC_SERVER_ERROR(2L, FaultCode.GENERAL_ERROR),

	/** Triggered when connection with Analytic Server cannot be established. */
	AS_CONNECTION_FAILED(3L, FaultCode.GENERAL_ERROR),

	/** Triggered in case of database communication error. */
	DATABASE_ERROR(4L, FaultCode.GENERAL_ERROR),

	/** Triggered in case of I/O communication Error. */
	IO_ERROR(5L, FaultCode.GENERAL_ERROR),

	/** Triggered in case of Application Configuration Error. */
	CONFIGURATION_ERROR(6L, FaultCode.GENERAL_ERROR),

	/** Triggered in case of Authentication Error. */
	AUTHENTICATION_ERROR(7L, FaultCode.GENERAL_ERROR),

	/* Invalid Request Errors */
	/** Errors potentially regarding the mandatory parameter format or type. */
	GENERAL_VALIDATION_ERROR(100L, FaultCode.INVALID_REQUEST),

	/** Errors potentially regarding the mandatory parameter format or type. */
	MANDATORY_PARAMETER_FORMAT(101L, FaultCode.INVALID_REQUEST),

	/** Errors potentially regarding the optional parameter format or type. */
	OPTIONAL_PARAMETER_FORMAT(102L, FaultCode.INVALID_REQUEST),

	/** The unique identifier missing. This is the default faultID for AnalyticServerUniqueIdentifierMissingException */
	UNIQUE_IDENTIFIER_MISSING(103L, FaultCode.INVALID_REQUEST),

	/** The no resource found by given id. This is triggered when we found no result for a given primary key. */
	NO_RESOURCE_FOUND_BY_GIVEN_ID(104L, FaultCode.INVALID_REQUEST),

	/** The no resource found by file path. This is triggered when we found no result for a given VM file path. */
	NO_RESOURCE_FOUND_BY_FILE_PATH(105L, FaultCode.INVALID_REQUEST),

	/** Triggered when one or more fields of request body objects have not passed the validation instructed by annotation. */
	INVALID_METHOD_ARGUMENTS(106L, FaultCode.INVALID_REQUEST),

	/** Triggered when one or more mandatory parameters are not supplied by the client. */
	MISSING_PARAMETERS(107L, FaultCode.INVALID_REQUEST),

	/* Logical Errors */
	/** The missing parameters. This is triggered when one or more mandatory parameters are not supplied by the client. */
	GENERAL_LOGICAL_ERROR(200L, FaultCode.LOGICAL_ERROR);

	/** The id reference. */
	private final Long idRef;

	/** The {@link FaultCode} that this {@link FaultId} has as category. */
	private final FaultCode faultCode;

	/**
	 * Instantiates a new {@link FaultId}.
	 *
	 * @param idRef the id ref
	 * @param faultCode the fault code
	 */
	private FaultId(final Long idRef, final FaultCode faultCode) {
		this.idRef = idRef;
		this.faultCode = faultCode;
	}

	/**
	 * Gets the {@link FaultId} for the given case.
	 *
	 * @return the id reference
	 */
	public Long getIdRef() {
		return idRef;
	}

	/**
	 * Gets the {@link FaultCode} for the given case.
	 *
	 * @return the fault code
	 */
	public FaultCode getFaultCode() {
		return faultCode;
	}

	/**
	 * Gets the {@link FaultId} as string.
	 *
	 * @return the {@link FaultId} as string
	 */
	public String getIdRefToString() {
		return Long.toString(idRef);
	}

	/**
	 * Gets the {@link FaultId} associated with passed {@link FaultCode}.
	 *
	 * @param faultCode the {@link FaultCode} for which we want all associated {@link FaultId}s
	 * @return the {@link FaultId}s associated with passed {@link FaultCode}.
	 */
	public static Set<FaultId> getFaultIdsByFaultCode(final FaultCode faultCode) {
		Set<FaultId> resultFaultIds = null;
		for (final FaultId faultIdItem : FaultId.values()) {
			if (faultIdItem.getFaultCode().equals(faultCode)) {
				if (resultFaultIds == null) {
					resultFaultIds = new LinkedHashSet<FaultId>();
				}
				resultFaultIds.add(faultIdItem);
			}
		}
		return resultFaultIds;
	}

}
