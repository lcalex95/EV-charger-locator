package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Area {
	@JacksonXmlProperty(localName = "name")
    @JacksonXmlElementWrapper(useWrapping = false)
	private String name;
	
	@JacksonXmlProperty(localName = "districtList")
    @JacksonXmlElementWrapper(useWrapping = true)
	private DistrictList districtList;
	
	public String getName()
	{
		return name;
	}
	
	public DistrictList getDistrictList()
	{
		return districtList;
	}
}
