package ee4216.group10.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class ChargerLocation {
	@JacksonXmlProperty(localName = "no")
	private String no;
	@JacksonXmlProperty(localName = "location")
	private String location;
	@JacksonXmlProperty(localName = "lat")
	private String lat;
	@JacksonXmlProperty(localName = "lng")
	private String lng;
	@JacksonXmlProperty(localName = "type")
	private String type;
	@JacksonXmlProperty(localName = "districtL")
	private String districtL;
	@JacksonXmlProperty(localName = "districtS")
	private String districtS;
	@JacksonXmlProperty(localName = "address")
	private String address;
	@JacksonXmlProperty(localName = "provider")
	private String provider;
	@JacksonXmlProperty(localName = "parkingNo")
	private String parkingNo;
	@JacksonXmlProperty(localName = "img")
	private String img;
	
/*	
 	public ChargerLocation(int stationNo, float lat, float lng, String chargeType, String districtL, String districtS, String adr, String provider, String parkingNo)
	{
		this.station_no = stationNo;
		this.latitude = lat;
		this.longtitude =lng;
		this.charge_type = chargeType;
		this.district_L=districtL;
		this.district_S = districtS;
		this.address=adr;
		this.provider=provider;
		this.parking_no=parkingNo;
	}
	*/
	
	public String getStationNo()
	{
		return no;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getLatitude()
	{
		return lat;
	}
	
	public String getLongtitude()
	{
		return lng;
	}
	
	public String getChargeType()
	{
		return type;
	}

	public String getLargeDistrict()
	{
		return districtL;
	}
	
	public String getSmallDistrict()
	{
		return districtS;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getProvider()
	{
		return provider;
	}
	
	public String getParkingNo()
	{
		return parkingNo;
	}
	
	public String getImg()
	{
		return img;
	}
}
