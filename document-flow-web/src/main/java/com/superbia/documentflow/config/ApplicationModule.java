package com.superbia.documentflow.config;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.PrintStream;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.superbia")
public class ApplicationModule implements EmbeddedServletContainerCustomizer {

  @Override
  public void customize(ConfigurableEmbeddedServletContainer container) {
    
  }

  /*@Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {
    return (container -> {
      container.addErrorPages(
        new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html"),
        new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"),
        new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html")
      );
    });
  }*/

  public static void main(String[] args) {

    ResourceLoader resourceLoader = new DefaultResourceLoader(ApplicationModule.class.getClassLoader());
    Resource resource = resourceLoader.getResource("banner.txt");
    Banner banner = new ResourceBanner(resource);

    new SpringApplicationBuilder()
      .sources(ApplicationModule.class)
      .logStartupInfo(true)
      .showBanner(true)
      .banner(banner)
      .run(args);

    // SpringApplication.run(ApplicationModule.class, args);
  }
}