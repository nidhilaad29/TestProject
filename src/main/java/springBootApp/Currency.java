package springBootApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.RequestEntity;


public class Currency {

	Map<String,Integer> map = new HashMap<String,Integer>();
	
	
	public Currency()
	{
		map.put("Rupees",60);
		map.put("CanDollars", 2);
		map.put("SinDollars",8);
	}
	
	public Map<String,Integer> getCurrency()
	{
		return map;
	}
	
}
