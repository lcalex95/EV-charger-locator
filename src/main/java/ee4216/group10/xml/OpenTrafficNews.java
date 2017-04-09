package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "body")
public class OpenTrafficNews {
	@JacksonXmlProperty(isAttribute = true)
	private String schemaLocation;
	
	@JacksonXmlProperty(localName = "message")
	@JacksonXmlElementWrapper(useWrapping = false)
	private TrafficMessage[] trafficMessage;
	
	
	public TrafficMessage[] getTrafficMessage()
	{
		return trafficMessage;
	}
	
}
