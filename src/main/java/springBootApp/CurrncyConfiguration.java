package springBootApp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrncyConfiguration {

	@ConfigurationProperties
	@Bean
	public Currency getContextCurrency()
	{
		return new Currency();
	}
	
	@ConfigurationProperties
	@Bean 
	public CurrencyService getCurrencyService()
	{
		return new CurrencyService();
	}
}
