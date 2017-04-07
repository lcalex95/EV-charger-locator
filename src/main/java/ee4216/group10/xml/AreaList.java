package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AreaList {
	@JacksonXmlProperty(localName = "area")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Area[] area;
	
	public Area[] getArea()
	{
		return area;		
	}
}
