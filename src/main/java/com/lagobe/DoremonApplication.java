package com.lagobe;

import java.io.File;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.lagobe.constants.ApplicationConstant;


@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.lagobe.models")
public class DoremonApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DoremonApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("th", "TH", "Th"));
		return slr;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("messages/message");  // name of the resource bundle 
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		File theDir = new File(ApplicationConstant.TemporaryFolder);
		if(!theDir.exists()){
			theDir.mkdirs();
		}
	}
}
