package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ChargingStationData")
public class OpenChargerLocation {
	@JacksonXmlProperty(localName = "Language")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String Language;
    
	@JacksonXmlProperty(localName = "stationList")
	@JacksonXmlElementWrapper(useWrapping = true)
	private StationList stationList;
	
	@JacksonXmlProperty(localName = "areaList")
	@JacksonXmlElementWrapper(useWrapping = true)
	private AreaList areaList;

	public StationList getStationList()
	{
		return stationList;
	}
	public String getLanguage()
	{
		return Language;
	}
}
