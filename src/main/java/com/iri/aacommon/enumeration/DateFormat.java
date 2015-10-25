package com.iri.aacommon.enumeration;

/** The Enum DateFormat represents all supported date and time format options. */
public enum DateFormat {

	/** The basic format using day, month and year precision. */
	DATE_PRECISION("dd/MM/yyyy"),

	/** The format with which bus responds using day, month and year precision. */
	DATE_BUS_PRECISION("yyyyMMdd"),

	/** The full format using up to second precision. */
	DATE_TO_SEC_PRECISION("dd/MM/yyyy HH:mm:ss"),

	/** The full format using up to second precision. */
	DATE_TO_SEC_PRECISION_REVERSE("yyyy-MM-dd HH:mm:ss"),

	/** The US based format. */
	US_DATE("yyyy-MM-dd"),

	/** The us date month first. */
	US_DATE_MONTH_PRECISION("MM/dd/yyyy");

	/** The date format. */
	private String format;

	/**
	 * Instantiates a new {@link DateFormat}.
	 *
	 * @param format the format
	 */
	private DateFormat(final String format) {
		this.format = format;
	}

	/**
	 * Gets the format of current {@link DateFormat}.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return this.format;
	}
}
