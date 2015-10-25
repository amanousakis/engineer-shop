package com.iri.aacommon.enumeration;

public enum TokenErrorCodeEnum {
	GENERAL_ERROR("GENERAL_ERROR"),
	
	TOKEN_RETRIEVAL_ERROR("TOKEN_RETRIEVAL_ERROR"),
	
	SESSION_TIMEOUT_ERROR("SESSION_TIMEOUT_ERROR");
	
	private String code;
	
	private TokenErrorCodeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
