package mydev.domain;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import mydev.util.MyDate;
import mydev.util.MyLocalDateXmlAdapter;

@XmlRootElement(name = "ObjDetail")
@JsonRootName(value = "ObjDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjDetail {
	@XmlElement(name = "lineId")
	private Long lineId;
	@XmlElement(name = "itemNo")
	private String itemNo;
	@XmlElement(name = "itemDesc")
	private String itemDesc;
	@XmlElement(name = "orderDate")
	@XmlJavaTypeAdapter(MyLocalDateXmlAdapter.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern=MyDate.DATE_PATTERN)
	private LocalDate orderDate;
	@XmlElement(name = "orderQty")
	@JsonProperty(value="orderQty")
	private Double qty;

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "ObjDetail [lineId=" + lineId + ", itemNo=" + itemNo + ", itemDesc=" + itemDesc + ", orderDate="
				+ orderDate + ", qty=" + qty + "]";
	}

}
