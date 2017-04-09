package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TrafficMessage {
	@JacksonXmlProperty(localName = "msgID")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String msgID;
	@JacksonXmlProperty(localName = "CurrentStatus")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String currentStatus;
	@JacksonXmlProperty(localName = "ChinText")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String ChinText;
	@JacksonXmlProperty(localName = "ChinShort")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String ChinShort;
	@JacksonXmlProperty(localName = "EngText")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String EngText;
	@JacksonXmlProperty(localName = "EngShort")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String EngShort;	
	@JacksonXmlProperty(localName = "ReferenceDate")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String RefDate;
	@JacksonXmlProperty(localName = "IncidentRefNo")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String IncidentRefNo;
	@JacksonXmlProperty(localName = "CountofDistricts")
	@JacksonXmlElementWrapper(useWrapping = false)
	private String CountofDistricts;
	@JacksonXmlProperty(localName = "ListOfDistrict")
	@JacksonXmlElementWrapper(useWrapping = false)
	private TrafficNewsDistrict[] trafficNewsDistrict;
	
	public String getMsgID()
	{
		return msgID;
	}
	public String getStatus()
	{
		return currentStatus;
	}
	public String getChinText()
	{
		return ChinText;
	}
	public String getChinShort()
	{
		return ChinShort;
	}
	public String getEngText()
	{
		return EngText;
	}
	public String getEngShort()
	{
		return EngShort;
	}
	public String getRefDate()
	{
		return RefDate;
	}
	public String getIncidentRefNo()
	{
		return IncidentRefNo;
	}
	public String getCountofDistricts()
	{
		return CountofDistricts;
	}
	public TrafficNewsDistrict[] getDistrictList()
	{
		return trafficNewsDistrict;
	}
	
}
