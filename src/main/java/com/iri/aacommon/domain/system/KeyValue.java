package com.iri.aacommon.domain.system;

import java.io.Serializable;

/**
 * The Class KeyValue.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class KeyValue<K, V> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2379454105931866556L;

	/** The key. */
	private K key;

	/** The value. */
	private V value;

	/**
	 * Instantiates a new key value.
	 */
	public KeyValue() {}

	/**
	 * Instantiates a new key value.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public KeyValue(final K key, final V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(final K key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(final V value) {
		this.value = value;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("KeyValue [key=");
		builder.append(key);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final KeyValue other = (KeyValue) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
