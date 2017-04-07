package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StationList {
	@JacksonXmlProperty(localName = "station")
    @JacksonXmlElementWrapper(useWrapping = false)
	private ChargerLocation[] station;
	
	public ChargerLocation[] getStation()
	{
		return station;
	}
}
