package springBootApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CurrencyService {
	@Autowired
	Currency currency;// = new Currency();

	public Map<String,Integer> getServiceCurrency() {
		return currency.getCurrency();		
	}
	public Map<String,Integer> getMatchCurrency(String name)
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(Entry<String,Integer> entry : currency.map.entrySet())
		{
			
			if(entry.getKey().equals(name))
			{				
				map.put(entry.getKey(),entry.getValue());
			}
		}
		return map;
	}
	public ResponseEntity<Currency> createCurrency(CurrencyRequest request) {
		currency.map.put(request.getName(),request.getValue());
		System.out.println(currency.getCurrency());
		return new ResponseEntity<Currency>(HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<Currency> updateCurrency(String name ,CurrencyRequest request) {
		
		Map<String,Integer> map = getMatchCurrency(name);
		if(!map.isEmpty())
		{
			currency.map.put(name,request.getValue());
			System.out.println(currency.getCurrency());
			return new ResponseEntity<Currency>(HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<Currency>(HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<Currency> deleteCurrency(String name) {
		
		Map<String,Integer> map = getMatchCurrency(name);
		if(!map.isEmpty())
		{
			currency.map.remove(name);
			return new ResponseEntity<Currency>(HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<Currency>(HttpStatus.NOT_FOUND);
	}

}
