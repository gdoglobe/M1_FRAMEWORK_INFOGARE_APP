package fr.pantheonsorbonne.ufr27.miage.model.jaxb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapterDto extends XmlAdapter<String, Date> {

	
	private final DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	 @Override
	 public Date unmarshal(String xml) throws Exception {
	  return dateFormat.parse(xml);
	 }

	 @Override
	 public String marshal(Date object) throws Exception {
	  return dateFormat.format(object);
	 }

}