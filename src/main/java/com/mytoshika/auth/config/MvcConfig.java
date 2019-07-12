package com.mytoshika.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mytoshika.auth.exception.RestTemplateResponseErrorHandler;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author pussingh5
 *
 * This is MVC Configuration file.
 */

@Configuration
@EnableSwagger2
public class MvcConfig implements WebMvcConfigurer{
	
	@Bean
	public RestTemplate restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
		//restTemplate.setInterceptors(interceptors);
		
		return restTemplate;
	}

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.macquire.rmg.auth.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }
    
    private ApiInfo metaData() {
        
        return new ApiInfoBuilder().title("cmprsk-auth-ms")
        		.description("Auto generated endpoints to test the API.")
        		.version("1.0.1")
        		.license("")
        		.build();
    }
}