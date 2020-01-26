package mydev.domain;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MyExec {

	public static void main(String[] args) {
		String myXml = "<MyObj>\r\n" + 
				"  <startDate>2020-01-21</startDate>\r\n" + 
				"  <endDate/>\r\n" + 
				"  <creationDate>2020-01-21 11:02:19</creationDate>\r\n" + 
				"  <objectId>1</objectId>\r\n" + 
				"  <objectCode>X001</objectCode>\r\n" + 
				"  <objectName>Object Name</objectName>\r\n" + 
				"  <objectDetail>\r\n" + 
				"    <objectDetail>\r\n" + 
				"      <lineId>1</lineId>\r\n" + 
				"      <itemNo>XA-001</itemNo>\r\n" + 
				"      <itemDesc>Object detail description 1</itemDesc>\r\n" + 
				"      <orderDate>2020-01-22</orderDate>\r\n" + 
				"      <orderQty>6.89</orderQty>\r\n" + 
				"    </objectDetail>\r\n" + 
				"    <objectDetail>\r\n" + 
				"      <lineId>2</lineId>\r\n" + 
				"      <itemNo>XA-002</itemNo>\r\n" + 
				"      <itemDesc>Object detail description 2</itemDesc>\r\n" + 
				"      <orderDate>2020-01-23</orderDate>\r\n" + 
				"      <orderQty>15.79</orderQty>\r\n" + 
				"    </objectDetail>\r\n" + 
				"    <objectDetail>\r\n" + 
				"      <lineId>3</lineId>\r\n" + 
				"      <itemNo>XA-003</itemNo>\r\n" + 
				"      <itemDesc>Object detail description 3</itemDesc>\r\n" + 
				"      <orderDate>2020-01-24</orderDate>\r\n" + 
				"      <orderQty>23.56</orderQty>\r\n" + 
				"    </objectDetail>\r\n" + 
				"  </objectDetail>\r\n" + 
				"</MyObj>";
		
		MyObj1 obj = new MyObj1();
		obj.setObjId(1L);
		obj.setObjCode("X001");
		obj.setObjName("Object Name");
		obj.setCreationDate(LocalDateTime.now());
		obj.setStartDate(LocalDate.now());
		List<ObjDetail> objDetail = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			ObjDetail o = new ObjDetail();
			o.setLineId(new Long(i));
			o.setItemNo("XA-00" + i);
			o.setItemDesc("Object detail description " + i);
			o.setOrderDate(LocalDate.now().plusDays(i));
			o.setQty(i + Math.random() * 10 * i);
			objDetail.add(o);
		}
		obj.setObjLine(objDetail);		
		try {
			ObjectMapper objMapper = new ObjectMapper();
			objMapper.registerModule(new JavaTimeModule());
			objMapper.enable(SerializationFeature.INDENT_OUTPUT);
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.registerModule(new JavaTimeModule());
			xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
			JAXBContext jaxbCtx;
			jaxbCtx = JAXBContext.newInstance(MyObj1.class);
			Marshaller marshaller = jaxbCtx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.marshal(obj, System.out);
			Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
			MyObj1 xObj = (MyObj1) unmarshaller.unmarshal(new StringReader(myXml));
			System.out.println();
			System.out.println(xObj);
			System.out.println(objMapper.writeValueAsString(obj));
			System.out.println(xmlMapper.writeValueAsString(obj));
			System.out.println(xmlMapper.readValue(new StringReader(myXml), MyObj1.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
