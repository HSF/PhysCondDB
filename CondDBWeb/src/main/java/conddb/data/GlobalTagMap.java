package conddb.data;

// Generated Aug 25, 2014 4:52:00 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * GlobalTagMap generated by hbm2java
 */
@Entity
@Table(name = "GLOBAL_TAG_MAP",
	uniqueConstraints=@UniqueConstraint(columnNames={"TAG_ID", "GLOBAL_TAG_NAME"}))
//)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class GlobalTagMap implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5242844765295102068L;
	private Long id;
	private Tag systemTag;
	private GlobalTag globalTag;
	private String record;
	private String label;
	public GlobalTagMap() {
	}

	public GlobalTagMap(GlobalTag gtag, Tag stag) {
		this.globalTag=gtag;
		this.systemTag=stag;
		this.record="none";
		this.label="none";
	}

	/**
	 * @param systemTag
	 * @param globalTag
	 * @param record
	 * @param label
	 */
	public GlobalTagMap(Tag systemTag, GlobalTag globalTag, String record,
			String label) {
		super();
		this.systemTag = systemTag;
		this.globalTag = globalTag;
		this.record = record;
		this.label = label;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GLOBAL_TAG_NAME")
	public GlobalTag getGlobalTag() {
		return this.globalTag;
	}
	
	
	public void setGlobalTag(GlobalTag globalTag) {
		this.globalTag = globalTag;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAG_ID")
	public Tag getSystemTag() {
		return systemTag;
	}
	
	public void setSystemTag(Tag systemTag) {
		this.systemTag = systemTag;
	}

	@Column(name = "RECORD", nullable = false, length = 100)
	public String getRecord() {
		return this.record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Column(name = "LABEL", nullable = false, length = 100)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Transient
	public String getTagName() {
		return this.systemTag.getName();
	}
	
	@Transient
	public String getGlobalTagName() {
		return this.globalTag.getName();
	}


}
