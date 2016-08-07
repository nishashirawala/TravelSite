package com.travel.model.common;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The base object for objects that have auto generated ids and hibernate
 * versions. It also implements a toString() and an accurate hashCode() and an
 * accurate equals() function based upon a candidate key.
 * 
 * Subclasses should override the equals() method to check instanceof.
 * Subclasses may choose to override createVerboseToStringMap() to add more
 * fields to toString() Subclasses may choose to override createCandidateKey()
 * to add real candidate keys (unique fields) to such as user name or deviceId
 * 
 */
public class BaseIdentifiedObject extends AbstractBaseObject {

	private static final long serialVersionUID = -3920379880988177247L;

	private final Log log = LogFactory.getLog(getClass());

	private Long id;

	private Long version = new Long(-1);

	private Date creationDate = new Date();
	
	private Date modificationDate = new Date();

	/**
	 * Creates an instance
	 * 
	 */
	public BaseIdentifiedObject() {
		super();

	}

	/**
	 * Returns the unique id for this object
	 * 
	 * @struts.form-field
	 * @hibernate.id column="id" type="int" generator-class="native"
	 *               unsaved-value="null" type="long"
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique id for this object
	 * 
	 * @param uid
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the hibernate version field
	 * 
	 * @struts.form-field
	 * @hibernate.version column="version" unsaved-value="negative" type="long"
	 *                    access="property"
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * Sets the hibernate version field
	 * 
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * Returns the date this object was created
	 * 
	 * @hibernate.property column="creation_date" not-null="true" insert="true"
	 *                     update="false"
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Return the field that is considered the primary key. This is usually the
	 * hibernate managed id but some objects require a business field to be the
	 * unique primary key.
	 */
	public Serializable getPrimaryKey() {
		return this.id;
	}

	/**
	 * Basic implementation of toString()
	 * 
	 */
	public String toString() {
		Map m = new HashMap();
		m.put("id", this.id);

		// we only print the verbose version in debug mode
		if (log.isDebugEnabled())
			m = createVerboseToStringMap(m);

		return toStringFromMap(m);
	}

	/**
	 * Compares to objects for equality. Checks the unique id Returns true only
	 * in the case that both objects have the same id or both objects have a
	 * null id.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof BaseIdentifiedObject))
			return false;

		BaseIdentifiedObject another = (BaseIdentifiedObject) o;

		String ckey = createCandidateKey();
		String anotherCkey = another.createCandidateKey();

		if (anotherCkey == null && ckey == null)
			return true;

		if (anotherCkey != null && ckey == null)
			return false;

		if (anotherCkey == null && ckey != null)
			return false;

		boolean areEqual = anotherCkey.equals(ckey);
		return areEqual;

	}

	/**
	 * Default implementation of hashCode. Determines equality by using the
	 * unique id as the hash. If the unique id is null, two objects are equal.
	 */
	public int hashCode() {
		String ckey = createCandidateKey();
		if (ckey == null) {
			return 0;
		} else {
			int hash = ckey.hashCode();
			return hash;
		}
	}

	/**
	 * Tests to see if this object has an id or not indicating that it is a new
	 * (create) or an existing (update) object
	 */
	public boolean isNew() {
		return version != null && version.longValue() < 0;
	}

	/**
	 * A convience method used to create the String returned from toString()
	 * 
	 */
	private String toStringFromMap(Map attrs) {
		StringBuffer buf = new StringBuffer();

		buf.append("[");
		buf.append(this.getClass().getName());
		buf.append(" ( ");
		for (Iterator it = attrs.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			buf.append(entry.getKey());
			buf.append(" = ");
			buf.append(entry.getValue());

			if (it.hasNext())
				buf.append(", ");
		}
		buf.append(" )]");
		return buf.toString();
	}

	/**
	 * Override this method to add additional fields to a sub-class's verbose
	 * toString()
	 * 
	 */
	protected Map createVerboseToStringMap(Map m) {
		if (m == null)
			m = new HashMap();

		m.put("version", this.version);
		m.put("creationDate", this.creationDate);
		m.put("modificationDate", this.modificationDate);
		return m;
	}

	/**
	 * Creates a unique string that can be used as a candidate key for equals()
	 * hashcode() For best practices, see Hibernate Documentation:
	 * http://www.hibernate.org/109.html
	 */
	protected String createCandidateKey() {
		if (id != null && id.longValue() > 0) {
			return id.toString();
		} else {
			long d = creationDate.getTime();
			return String.valueOf(d);
		}
	}

	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate
	 *            the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
}
