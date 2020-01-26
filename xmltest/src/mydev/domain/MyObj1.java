package mydev.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import mydev.util.MyDate;
import mydev.util.MyLocalDateTimeXmlAdapter;
import mydev.util.MyLocalDateXmlAdapter;

@XmlRootElement(name = "MyObj"/* ,namespace = "http://it.mydev" */)
@JsonRootName(value = "MyObj"/* ,namespace = "http://it.mydev" */)
@XmlAccessorType(XmlAccessType.FIELD)
public class MyObj1 {
	@XmlElement(name = "objectId")
	@JsonProperty(value = "objectId")
	private Long objId;
	@XmlElement(name = "objectCode")
	@JsonProperty(value = "objectCode")
	private String objCode;
	@XmlElement(name = "objectName")
	@JsonProperty(value = "objectName")
	private String objName;
	@XmlElement(name = "objectDetail")
	@XmlElementWrapper(name = "objectDetail")
	@JsonProperty(value = "objectDetail")
	private List<ObjDetail> objLine;
	@XmlElement(name = "startDate")
	@XmlJavaTypeAdapter(MyLocalDateXmlAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MyDate.DATE_PATTERN)
	private LocalDate startDate;
	@XmlElement(name = "endDate")
	@XmlJavaTypeAdapter(MyLocalDateXmlAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MyDate.DATE_PATTERN)
	private LocalDate endDate;
	@XmlElement(name = "creationDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MyDate.DATETIME_PATTERN)
	@XmlJavaTypeAdapter(MyLocalDateTimeXmlAdapter.class)
	private LocalDateTime creationDate;

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getObjCode() {
		return objCode;
	}

	public void setObjCode(String objCode) {
		this.objCode = objCode;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public List<ObjDetail> getObjLine() {
		return objLine;
	}

	public void setObjLine(List<ObjDetail> objLine) {
		this.objLine = objLine;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "MyObj1 [objId=" + objId + ", objCode=" + objCode + ", objName=" + objName + ", objLine=" + objLine
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", creationDate=" + creationDate + "]";
	}

}
