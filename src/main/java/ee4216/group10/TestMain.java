package ee4216.group10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ee4216.group10.xml.ChargerLocation;
import ee4216.group10.xml.OpenChargerLocation;

public class TestMain {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub

			String url = "https://opendata.clp.com.hk/GetChargingSectionXML.aspx?lang=%3CLANG%3E";

			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);

			// add request header
			//request.addHeader("User-Agent", USER_AGENT);

			HttpResponse response = client.execute(request);

			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " +
	                       response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
	                       new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			
			
			/*System.out.println(result.toString());*/
			XmlMapper mapper = new XmlMapper();
			OpenChargerLocation openChargerLocation = mapper.readValue(result.toString(), OpenChargerLocation.class);
			for (int i =0 ; i< openChargerLocation.getStationList().getStation().length; i ++)
			{
				System.out.println(openChargerLocation.getStationList().getStation()[i].getLocation() + " Latitude: " + openChargerLocation.getStationList().getStation()[i].getLatitude() + " Longtitude: " + openChargerLocation.getStationList().getStation()[i].getLongtitude());
			}
			
	}

}
