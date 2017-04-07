package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class District {
	
	@JacksonXmlProperty(localName = "name")
	private String name;
	
	public String getName()
	{
		return name;
	}
	
}
