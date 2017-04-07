package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DistrictList {
	
	@JacksonXmlProperty(localName = "district")
    @JacksonXmlElementWrapper(useWrapping = false)
	private District[] district;
	
	public District[] getDistrict()
	{
		return district;
	}
	
}
