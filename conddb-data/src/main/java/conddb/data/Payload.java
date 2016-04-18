package conddb.data;

// Generated Aug 25, 2014 4:52:00 PM by Hibernate Tools 3.4.0.CR1

//import conddb.data.deserialiser.*;
//import conddb.mappers.deserializers.PayloadDeserializer;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import conddb.data.annotations.Linkit;

/**
 * Payload generated by hbm2java
 */
@Entity
@Table(name = "PHCOND_PAYLOAD")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="hash", scope = Payload.class)
public class Payload extends conddb.data.AfEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6319755970273574624L;
	private String hash;
	private String version;
	private String objectType;
	private Integer datasize; // size in bytes of the payload
	private String streamerInfo;
	private String backendInfo="db://PHCOND_PAYLOAD_DATA";
	private Timestamp insertionTime;
	private PayloadData data = null;
	private Set<Iov> iovs = new HashSet<Iov>(0);
	
	public Payload() {

	}

	public Payload(String hash, String objectType, String backendInfo,
			String streamerInfo, String version) {
		this.hash = hash;
		this.objectType = objectType;
		this.backendInfo = backendInfo;
		this.streamerInfo = streamerInfo;
		this.version = version;
	}

	public Payload(String hash, String objectType, String backendInfo,
			String streamerInfo, Timestamp insertionTime,  String version, Set<Iov> iovs) {
		this.hash = hash;
		this.objectType = objectType;
		this.backendInfo = backendInfo;
		this.streamerInfo = streamerInfo;
		this.insertionTime = insertionTime;
		this.version = version;
		this.iovs = iovs;
	}

	@Id
	@Column(name = "HASH", unique = true, nullable = false, length = 256)
	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Column(name = "VERSION", nullable = false, length = 20)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "OBJECT_TYPE", nullable = false, length = 100)
	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	
	@Column(name = "BACKEND_INFO", nullable = true)
	@Lob @Basic(fetch=FetchType.LAZY)
	public String getBackendInfo() {
		return backendInfo;
	}

	public void setBackendInfo(String backendInfo) {
		this.backendInfo = backendInfo;
	}

	@Column(name = "STREAMER_INFO", nullable = true)
	@Lob @Basic(fetch=FetchType.LAZY)
	public String getStreamerInfo() {
		return this.streamerInfo;
	}

	public void setStreamerInfo(String streamerInfo) {
		this.streamerInfo = streamerInfo;
	}
	
	@Column(name = "DATA_SIZE", nullable = false, precision = 12, scale = 0)
	public Integer getDatasize() {
		return datasize;
	}

	public void setDatasize(Integer datasize) {
		this.datasize = datasize;
	}

	//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERTION_TIME", nullable = false)
	public Timestamp getInsertionTime() {
		return this.insertionTime;
	}

	public void setInsertionTime(Timestamp insertionTime) {
		this.insertionTime = insertionTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payload")
	public Set<Iov> getIovs() {
		return this.iovs;
	}

	public void setIovs(Set<Iov> iovs) {
		this.iovs = iovs;
	}
	
	@Transient
	@Linkit(getter="getHash")
	public PayloadData getData() {
		return data;
	}

	public void setData(PayloadData data) {
		this.data = data;
	}

	@PrePersist
    public void prePersist() {
		Instant now = Instant.now();
        Timestamp nowt = Timestamp.from(now);
        this.insertionTime = nowt;
    }


	@Override
	public String toString() {
		return "Payload [hash=" + hash + ", version=" + version + ", objectType=" + objectType + ", datasize="
				+ datasize + ", streamerInfo=" + streamerInfo + ", backendInfo=" + backendInfo + ", insertionTime="
				+ insertionTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backendInfo == null) ? 0 : backendInfo.hashCode());
		result = prime * result + ((datasize == null) ? 0 : datasize.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((insertionTime == null) ? 0 : insertionTime.hashCode());
		result = prime * result + ((objectType == null) ? 0 : objectType.hashCode());
		result = prime * result + ((streamerInfo == null) ? 0 : streamerInfo.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payload other = (Payload) obj;
		if (backendInfo == null) {
			if (other.backendInfo != null)
				return false;
		} else if (!backendInfo.equals(other.backendInfo))
			return false;
		if (datasize == null) {
			if (other.datasize != null)
				return false;
		} else if (!datasize.equals(other.datasize))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (insertionTime == null) {
			if (other.insertionTime != null)
				return false;
		} else if (!insertionTime.equals(other.insertionTime))
			return false;
		if (objectType == null) {
			if (other.objectType != null)
				return false;
		} else if (!objectType.equals(other.objectType))
			return false;
		if (streamerInfo == null) {
			if (other.streamerInfo != null)
				return false;
		} else if (!streamerInfo.equals(other.streamerInfo))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
