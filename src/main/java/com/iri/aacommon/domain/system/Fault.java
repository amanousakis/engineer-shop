package com.iri.aacommon.domain.system;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class Fault contains additional information to resolve/debug cases where the actual service call has failed.
 */
@JsonPropertyOrder({ "faultId", "faultCode", "faultDescription" })
public class Fault {

	/** The fault id. */
	private Long faultId;

	/** The fault code. */
	private String faultCode;

	/** The fault description. */
	private String faultDescription;

	/**
	 * Gets the fault id.
	 *
	 * @return the fault id
	 */
	public Long getFaultId() {
		return faultId;
	}

	/**
	 * Sets the fault id.
	 *
	 * @param faultId the new fault id
	 */
	public void setFaultId(final Long faultId) {
		this.faultId = faultId;
	}

	/**
	 * Gets the fault code.
	 *
	 * @return the fault code
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * Sets the fault code.
	 *
	 * @param faultCode the new fault code
	 */
	public void setFaultCode(final String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * Gets the fault description.
	 *
	 * @return the fault description
	 */
	public String getFaultDescription() {
		return faultDescription;
	}

	/**
	 * Sets the fault description.
	 *
	 * @param faultDescription the new fault description
	 */
	public void setFaultDescription(final String faultDescription) {
		this.faultDescription = faultDescription;
	}

	/**
	 * Custom implementation of toString() method.
	 *
	 * @return string representation
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Fault [");
		if (faultId != null) {
			builder.append("faultId=").append(faultId).append(", ");
		}
		if (faultCode != null) {
			builder.append("faultCode=").append(faultCode).append(", ");
		}
		if (faultDescription != null) {
			builder.append("faultDescription=").append(faultDescription);
		}
		builder.append("]");
		return builder.toString();
	}

}
