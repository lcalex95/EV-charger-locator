package ee4216.group10.xml;


public class ChargerLocation {
	
	private int station_no;
	private float latitude;
	private float longtitude;
	private String charge_type;
	private String district_L;
	private String district_S;
	private String address;
	private String provider;
	private String parking_no;
	
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
	
	public int getStationNo()
	{
		return station_no;
	}
	
	public float getLatitude()
	{
		return latitude;
	}
	
	public float getLongtitude()
	{
		return longtitude;
	}
	
	public String getChargeType()
	{
		return charge_type;
	}

	public String getLargeDistrict()
	{
		return district_L;
	}
	
	public String getSmallDistrict()
	{
		return district_S;
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
		return parking_no;
	}
	
}
