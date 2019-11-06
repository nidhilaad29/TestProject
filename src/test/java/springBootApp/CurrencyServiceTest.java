package springBootApp;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CurrncyConfiguration.class })
@EnableConfigurationProperties
public class CurrencyServiceTest {
	@Autowired
	CurrencyService service ;
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCurrencyTest_match()
	{
		Map<String,Integer> map =service.getMatchCurrency("Rupees");
		Assert.assertEquals(false, map.keySet().isEmpty());
	}
	
	@Test
	public void getCurrencyTest_nomatch()
	{
		Map<String,Integer> map =service.getMatchCurrency("Noone");
		Assert.assertEquals(true, map.keySet().isEmpty());
	}
}
