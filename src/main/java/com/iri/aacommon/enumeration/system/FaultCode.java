package com.iri.aacommon.enumeration.system;

/**
 * The Enum FaultCode contains all fault codes for every operation made available from this module.
 */
public enum FaultCode {

	/** Fault code in case of generic error occurring while trying to service incoming request. Associated FaultId range is 1-99. */
	GENERAL_ERROR("_GeneralError"),

	/** Fault code in case of invalid request for a given service method. Associated FaultId range is 100-199. */
	INVALID_REQUEST("_InvalidRequest"),

	/** Fault code in case of logical error occurring while trying to service incoming request. Associated FaultId range is 200-299. */
	LOGICAL_ERROR("_LogicalError"),

	/** Fault code in case of disabled operation. Associated FaultId range is 900-999. */
	NOT_SUPPORTED_OPERATION("_NotSupportedOperation");

	/** The fault code name. */
	private final String name;

	/**
	 * Instantiates a new fault code name.
	 *
	 * @param name the fault code name
	 */
	private FaultCode(final String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the fault code name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
