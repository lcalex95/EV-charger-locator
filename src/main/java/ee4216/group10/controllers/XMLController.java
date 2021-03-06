package ee4216.group10.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ee4216.group10.xml.ChargerLocation;
import ee4216.group10.xml.OpenChargerLocation;
import ee4216.group10.xml.OpenTrafficNews;
import ee4216.group10.xml.TrafficMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/*
 * Controller for XML-related mappings.
 */

@Controller
public class XMLController {
	//https://opendata.clp.com.hk/GetChargingSectionXML.aspx?lang=%3CLANG%3E 
	//private final String USER_AGENT = "Mozilla/5.0";
	
	@RequestMapping(path = "/get-stations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private ResponseEntity<List<ChargerLocation>> sendGet() throws Exception {

		String url = "https://opendata.clp.com.hk/GetChargingSectionXML.aspx?lang=%3CLANG%3E";
		String result = getXml(url);
		
		XmlMapper mapper = new XmlMapper();
		OpenChargerLocation openChargerLocation = mapper.readValue(result, OpenChargerLocation.class);
		/*
		for (int i =0 ; i< openChargerLocation.getStationList().getStation().length; i ++)
		{
			System.out.println(openChargerLocation.getStationList().getStation()[i].getLocation() + " Latitude: " + openChargerLocation.getStationList().getStation()[i].getLatitude() + " Longtitude: " + openChargerLocation.getStationList().getStation()[i].getLongtitude());
		}
		*/
		List<ChargerLocation> locations = new ArrayList<ChargerLocation>();
		for(ChargerLocation location: openChargerLocation.getStationList().getStation()) {
			locations.add(location);
		}
		
		return new ResponseEntity<List<ChargerLocation>>(locations, HttpStatus.OK);
	}
	
	@RequestMapping("/details")
	public String stationDetails(@RequestParam("no") String no, Model model) throws ClientProtocolException, IOException {
		
		String url = "https://opendata.clp.com.hk/GetChargingSectionXML.aspx?lang=%3CLANG%3E";
		String result = getXml(url);
		
		XmlMapper mapper = new XmlMapper();
		OpenChargerLocation openChargerLocation = mapper.readValue(result, OpenChargerLocation.class);
		
		for(ChargerLocation location: openChargerLocation.getStationList().getStation()) {
			//System.out.println(location.getStationNo());
			if(location.getStationNo().equals(no)) {
				System.out.println("Charger at " + location.getLocation() + " found.");
				model.addAttribute("no", location.getStationNo());
				model.addAttribute("location", location.getLocation());
				model.addAttribute("address", location.getAddress());
				model.addAttribute("chargeType", location.getChargeType());
				model.addAttribute("parkingNo", location.getParkingNo());
				model.addAttribute("provider", location.getProvider());
				model.addAttribute("districtS", location.getSmallDistrict());
				model.addAttribute("districtL", location.getLargeDistrict());
				model.addAttribute("lat", location.getLatitude());
				model.addAttribute("lng", location.getLongtitude());
				break;
			}
		}
		
		return "station-details";
	}
	
	//Get Traffic News
	@RequestMapping(path = "/get-news", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private ResponseEntity<List<TrafficMessage>> sendGetNews() throws Exception {

		String url = "http://resource.data.one.gov.hk/td/en/specialtrafficnews.xml";
		String result = getXml(url);
		
		XmlMapper mapper = new XmlMapper();
		OpenTrafficNews openTrafficNews = mapper.readValue(result, OpenTrafficNews.class);

		List<TrafficMessage> trafficMessages = new ArrayList<TrafficMessage>();
		for(TrafficMessage trafficMessage: openTrafficNews.getTrafficMessage()) {
			trafficMessages.add(trafficMessage);
		}
		
		return new ResponseEntity<List<TrafficMessage>>(trafficMessages, HttpStatus.OK);
	}
	
	private String getXml(String url) throws ClientProtocolException, IOException {
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		return result.toString();
	}
	
}
