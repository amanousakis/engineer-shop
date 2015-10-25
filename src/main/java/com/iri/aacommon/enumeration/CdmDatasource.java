package com.iri.aacommon.enumeration;

/**
 * The Enum CdmDatasource.
 */
public enum CdmDatasource {

	/** The unknown. */
	UNKNOWN("UNKNOWN", "UNKNOWN"),

	/** The CDM data-source Node1. */
	NODE1("IRI/iMAS/DataSource/CDM/Node1", "CDM data-source Node1"),

	/** The CDM data-source Node1. */
	NODE1_1("IRI/iMAS/DataSource/CDM/Node1_1", "CDM data-source Node1_1"),

	/** The CDM data-source Node2. */
	NODE2("IRI/iMAS/DataSource/CDM/Node2", "CDM data-source Node2"),

	/** The CDM data-source Node3. */
	NODE3("IRI/iMAS/DataSource/CDM/Node3", "CDM data-source Node3"),

	/** The CDM data-source Node4. */
	NODE4("IRI/iMAS/DataSource/CDM/Node4", "CDM data-source Node4"),

	/** The CDM data-source Node5. */
	NODE5("IRI/iMAS/DataSource/CDM/Node5", "CDM data-source Node5"),

	/** The CDM data-source Node6. */
	NODE6("IRI/iMAS/DataSource/CDM/Node6", "CDM data-source Node6"),

	/** The CDM data-source Node7. */
	NODE7("IRI/iMAS/DataSource/CDM/Node7", "CDM data-source Node7"),

	/** The CDM data-source Node8. */
	NODE8("IRI/iMAS/DataSource/CDM/Node8", "CDM data-source Node8"),

	/** The CDM data-source Node9. */
	NODE9("IRI/iMAS/DataSource/CDM/Node9", "CDM data-source Node9"),

	/** The CDM data-source Node10. */
	NODE10("IRI/iMAS/DataSource/CDM/Node10", "CDM data-source Node10");

	/** The feature status id. */
	private final String jndiName;

	/** The feature status name. */
	private final String description;

	/**
	 * Instantiates a new cdm datasource.
	 *
	 * @param jndiName the jndi name
	 * @param description the description
	 */
	private CdmDatasource(final String jndiName, final String description) {
		this.jndiName = jndiName;
		this.description = description;
	}

	/**
	 * Gets the jndi name.
	 *
	 * @return the jndi name
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the CdmDatasource.
	 *
	 * @param jndiName the jndi name
	 * @return the cdm datasource
	 */
	public static CdmDatasource get(final String jndiName) {
		for (final CdmDatasource cdmDatasource : CdmDatasource.values()) {
			if (cdmDatasource.getJndiName().equals(jndiName))
				return cdmDatasource;
		}
		return UNKNOWN;
	}

}
