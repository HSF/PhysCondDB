package conddb.data;

// Generated Aug 25, 2014 4:52:00 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import conddb.utils.json.serializers.PayloadSerializer;

/**
 * Iov generated by hbm2java
 */
@Entity
@Table(name = "IOV", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"SINCE", "INSERTION_TIME", "TAG_ID" }) })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Iov implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7499748521778474013L;

	private Long id;
	private BigDecimal since;
	private String sinceString;
	private Date insertionTime;
	private Payload payload;
	private Tag tag;

	public Iov() {
	}

	public Iov(BigDecimal since, String sincestr, Date insertiontime,
			Payload payload, Tag tag) {
		this.since = since;
		this.sinceString = sincestr;
		this.insertionTime = insertiontime;
		this.payload = payload;
		this.tag = tag;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SINCE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSince() {
		return this.since;
	}

	public void setSince(BigDecimal since) {
		this.since = since;
	}

	@Column(name = "SINCE_STRING", nullable = false, length = 255)
	public String getSinceString() {
		return sinceString;
	}

	public void setSinceString(String sinceString) {
		this.sinceString = sinceString;
	}

	@JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERTION_TIME", nullable = false)
	public Date getInsertionTime() {
		return this.insertionTime;
	}

	public void setInsertionTime(Date insertionTime) {
		this.insertionTime = insertionTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYLOAD_HASH", nullable = false)
	@JsonSerialize(using = PayloadSerializer.class)
	public Payload getPayload() {
		return this.payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	// @//JsonBackReference(value="tag-iov")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAG_ID", nullable = false, updatable = false)
	@JsonBackReference(value = "tag-iov")
	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
