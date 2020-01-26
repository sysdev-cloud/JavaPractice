package mydev.util;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyLocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		return LocalDateTime.parse(v, MyDate.dateTimeFormatter);
	}

	@Override
	public String marshal(LocalDateTime v) throws Exception {
		return v.format(MyDate.dateTimeFormatter);
	}

}
