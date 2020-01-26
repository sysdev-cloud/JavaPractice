package mydev.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyLocalDateXmlAdapter extends XmlAdapter<String,LocalDate>{

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v, MyDate.dateFormatter);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.format(MyDate.dateFormatter);
	}

}
