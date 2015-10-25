package com.iri.aacommon.enumeration;

public enum Constants {
	AA_AUTH_SALT("iMASROCKSLIVESLONGFOREVER"),

	NO_PASSWORD_VALIDATION("ace");

	private String value;

	Constants(final String value) {
		this.setValue(value);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
