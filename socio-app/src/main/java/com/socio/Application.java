package com.socio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
//@PropertySource("file:${JETTY_HOME}/socio/application.properties")
@PropertySource("file:/opt/jetty/application.properties")
@ComponentScan("com.socio")
@EnableMBeanExport(registration=RegistrationPolicy.IGNORE_EXISTING)
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}