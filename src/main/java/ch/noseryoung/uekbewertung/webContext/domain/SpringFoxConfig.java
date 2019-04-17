/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lohse
 * 
 * This class got the configuration for swagger
 * and works as a middleman via SpringFox
 *
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean Docket apiDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ch.noseryoung.uekbewertung.webContext.domain"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	/**
	 * Got all needed Infos for the swagger documentation
	 * @return ApiInfoBuilder
	 */
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("\u00fcK-\u00DCbersicht").description("Description of Prototype Rest API")
			.termsOfServiceUrl("").contact(new Contact("Noser Young", "Modul Verwaltung", "zuerich@noseryoung.ch")).license("")
			.licenseUrl("").version("1.0").build();
	}
}
