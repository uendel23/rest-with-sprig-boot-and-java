package br.com.del.rest_with_sprig_boot_and_java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

     /*Via Extension. http://localhost:8080/api/v1.xml FOI DEPRECIADO NO SpringBoot 2,0
       Via QUERY PARAM http://localhost:8080/api/person/v1?mediaType=xml,
       não é muito bom passar tantos parametros pela URL por isso passaremos os parametros via header
       **/
//      configurer.favorParameter(true)
//              .parameterName("mediaType")
//              .ignoreAcceptHeader(true)
//              .useRegisteredExtensionsOnly(false)
//              .defaultContentType(MediaType.APPLICATION_JSON)
//              .mediaType("json",MediaType.APPLICATION_JSON)
//              .mediaType("xml",MediaType.APPLICATION_XML);


        // Via QUERY PARAM http://localhost:8080/api/person/v1
        //implementação parametros via header
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }
}
