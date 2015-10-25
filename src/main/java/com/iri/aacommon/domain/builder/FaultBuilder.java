package com.iri.aacommon.domain.builder;

import com.iri.aacommon.domain.system.Fault;

/**
 * The Class FaultBuilder.
 */
public class FaultBuilder extends FaultBuilderBase<FaultBuilder> {

	/**
	 * Fault.
	 *
	 * @return the fault builder
	 */
	public static FaultBuilder fault() {
		return new FaultBuilder();
	}

	/**
	 * Instantiates a new fault builder.
	 */
	public FaultBuilder() {
		super(new Fault());
	}

	/**
	 * Builds the Fault.
	 *
	 * @return the fault
	 */
	public Fault build() {
		return getInstance();
	}
}

class FaultBuilderBase<T extends FaultBuilderBase<T>> {
	private final Fault instance;

	protected FaultBuilderBase(final Fault aInstance) {
		instance = aInstance;
	}

	/**
	 * Gets the instance.
	 *
	 * @return the {@link Fault} instance
	 */
	protected Fault getInstance() {
		return instance;
	}

	/**
	 * With faultId.
	 *
	 * @param aValue the faultId
	 * @return the {@link FaultBuilder}
	 */
	@SuppressWarnings("unchecked")
	public T withFaultId(final Long aValue) {
		instance.setFaultId(aValue);

		return (T) this;
	}

	/**
	 * With faultCode.
	 *
	 * @param aValue the faultCode
	 * @return the {@link FaultBuilder}
	 */
	@SuppressWarnings("unchecked")
	public T withFaultCode(final String aValue) {
		instance.setFaultCode(aValue);

		return (T) this;
	}

	/**
	 * With faultDescription.
	 *
	 * @param aValue the faultDescription
	 * @return the {@link FaultBuilder}
	 */
	@SuppressWarnings("unchecked")
	public T withFaultDescription(final String aValue) {
		instance.setFaultDescription(aValue);

		return (T) this;
	}
}
