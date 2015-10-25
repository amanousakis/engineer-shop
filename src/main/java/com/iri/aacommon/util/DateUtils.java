package com.iri.aacommon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.iri.aacommon.enumeration.DateFormat;
import com.iri.aacommon.enumeration.SupportedLanguage;

/** The Class DateUtils holds constant object instances in order to be used throughout all extension projects. */
public final class DateUtils {

	/**
	 * The Constant FULL_DATE_FORMAT. It is used in order to format {@link java.util.Date} objects using up to second
	 * precision.
	 */
	private static final ThreadLocal<SimpleDateFormat> FULL_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DateFormat.DATE_TO_SEC_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
		}
	};

	/**
	 * The Constant FULL_DATE_FORMAT. It is used in order to format {@link java.util.Date} objects using up to second
	 * precision with reverse input of years and months in comparison with the simple one.
	 */
	private static final ThreadLocal<SimpleDateFormat> FULL_DATE_FORMAT_REVERSE = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DateFormat.DATE_TO_SEC_PRECISION_REVERSE.getFormat(), SupportedLanguage.getDefault().getLocale());
		}
	};

	/**
	 * The Constant BASIC_DATE_FORMAT. It is used in order to format {@link java.util.Date} objects using up to day
	 * precision.
	 */
	private static final ThreadLocal<SimpleDateFormat> BASIC_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DateFormat.DATE_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
		}
	};

	/**
	 * The Constant US_DATE_FORMAT. It is used in order to format {@link java.util.Date} objects using US related date
	 * format.
	 */
	private static final ThreadLocal<SimpleDateFormat> US_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DateFormat.US_DATE.getFormat(), SupportedLanguage.getDefault().getLocale());
		}
	};

	/**
	 * The Constant BUS_DATE_FORMAT. It is used in order to format {@link java.util.Date} objects using BUS related date
	 * format.
	 */
	private static final ThreadLocal<SimpleDateFormat> BUS_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DateFormat.DATE_BUS_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
		}
	};

	/** The Constant US_DATE_MONTH_PRECISION. */
	private static final ThreadLocal<SimpleDateFormat> US_DATE_MONTH_PRECISION = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DateFormat.US_DATE_MONTH_PRECISION.getFormat(), SupportedLanguage.getDefault().getLocale());
		}
	};

	/** The private constructor used to defeat warning about singleton and abstract classes. */
	private DateUtils() {
	}

	/**
	 * Gets the date using up to second precision.
	 *
	 * @param date the date to format
	 * @return the string representation
	 */
	public static String getDateInFullFormat(final Date date) {
		return FULL_DATE_FORMAT.get().format(date);
	}

	/**
	 * Gets the date using US format.
	 *
	 * @param date the date to format
	 * @return the string representation
	 */
	public static String getUSFormat(final Date date) {
		return US_DATE_FORMAT.get().format(date);
	}

	/**
	 * Gets the date using up to day precision..
	 *
	 * @param date the date to format
	 * @return the string representation
	 */
	public static String getDateInBasicFormat(final Date date) {
		return BASIC_DATE_FORMAT.get().format(date);
	}

	/**
	 * Gets the date in us month precision.
	 *
	 * @param date the date
	 * @return the date in us month precision
	 */
	public static String getDateInUSMonthPrecision(final Date date) {
		return US_DATE_MONTH_PRECISION.get().format(date);
	}

	/**
	 * Parses the date from basic format string.
	 *
	 * @param dateToken the date string
	 * @return the date from basic string format
	 * @throws java.text.ParseException the exception raised when date token is incompatible
	 */
	public static Date parseDateFromBasicFormatString(final String dateToken) throws ParseException {
		return BASIC_DATE_FORMAT.get().parse(dateToken);
	}

	/**
	 * Parses the date from bus format string.
	 *
	 * @param dateToken the date token
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date parseDateFromBUSFormatString(final String dateToken) throws ParseException {
		return BUS_DATE_FORMAT.get().parse(dateToken);
	}

	/**
	 * Parses the date from reverse full format string.
	 *
	 * @param dateToken the date string
	 * @return the date from basic string format
	 * @throws java.text.ParseException the exception raised when date token is incompatible
	 */
	public static Date parseDateFromFullFormatString(final String dateToken) throws ParseException {
		return FULL_DATE_FORMAT_REVERSE.get().parse(dateToken);
	}

	/**
	 * Parses the date from US format string.
	 *
	 * @param dateToken the date string
	 * @return the date from US string format
	 * @throws java.text.ParseException the exception raised when date token is incompatible
	 */
	public static Date parseDateFromFullUSFormatString(final String dateToken) throws ParseException {
		return FULL_DATE_FORMAT_REVERSE.get().parse(dateToken);
	}

	/**
	 * Parses the date from us month precisiont string.
	 *
	 * @param dateToken the date token
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date parseDateFromUSMonthPrecisiontString(final String dateToken) throws ParseException {
		return US_DATE_MONTH_PRECISION.get().parse(dateToken);
	}

}
