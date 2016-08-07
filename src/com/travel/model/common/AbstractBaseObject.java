package com.travel.model.common;

import java.io.Serializable;

/**
 * Every object in the com.einfochips.hhs.model should derive from this abstract
 * class and implement these methods.
 * 
 * Please consider deriving from BaseIdentifiedObject first
 * 
 * This formally forces each object to implement these methods so that we can
 * rely on them for various purposes
 * 
 */
public abstract class AbstractBaseObject implements Serializable {
	/**
	 * Implements a decent toString() that can be used in logging output etc.
	 * 
	 */
	public abstract String toString();

	/**
	 * Implements an equals function so that hashtables and arrays can be used
	 * properly
	 * 
	 */
	public abstract boolean equals(Object o);

	/**
	 * Implements a hash function so that hashtables and arrays can be used
	 * properly
	 * 
	 */
	public abstract int hashCode();
}
