package springBootApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/currency")
public class CurrencyController {
	
	@Autowired
	CurrencyService service ;
	@RequestMapping(path="/getCurrencies")
	public Map<String,Integer> getCurrencies()
	{
		return service.getServiceCurrency();
	}
	@RequestMapping(path="/getCurrency/{name}")
	public Map<String,Integer> getCurrency(@PathVariable String name)
	{
		return service.getMatchCurrency(name);
	}
	@RequestMapping(path="/createCurrency", method=RequestMethod.POST)
	public ResponseEntity<Currency> createCurrency(@RequestBody CurrencyRequest request)
	{
		return service.createCurrency(request);
	}
	
	@RequestMapping(path="/updateCurrency/{name}",method = RequestMethod.PUT)
	public ResponseEntity<Currency> updateCurrency( @RequestBody CurrencyRequest request,@PathVariable String name )
	{
		return service.updateCurrency(name ,request);
	}
	
	@RequestMapping(path="/deleteCurrency/{name}",method = RequestMethod.DELETE)
	public ResponseEntity<Currency> deleteCurrency( @PathVariable String name )
	{
		return service.deleteCurrency(name );
	}
	

}
