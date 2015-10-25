package com.iri.aacommon.enumeration;

public enum HttpHeaderParameters {

	AA_USER_ID("MAS-RAID"),

	AA_USER_NAME("MAS-User-Name"),

	AA_AUTH_TOKEN("mas-auth-token"),

	AA_CUSTOMER_ID("MAS-TNT-ID"),

	AA_MODULE_ID("mas-app-ctx-id"),

	AA_APPLICATION_ID("MAS-App-Id");

	private String value;

	HttpHeaderParameters(final String value) {
		this.setValue(value);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
