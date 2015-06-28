package com.superbia.documentflow.web.controllers;

import com.superbia.documentflow.config.ApplicationModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by dmorozov on 6/16/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationModule.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class HelloControllerIT {

  @Value("${local.server.port}")
  private int port = 0;

  private URL base;
  private RestTemplate template;

  @Before
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port + "/");
    template = new TestRestTemplate();
  }

  @Test
  public void getHello() throws Exception {
    ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
    assertTrue("Wrong body (title doesn't match):\n" + response.getBody(), response
        .getBody().contains("<title>Yet"));
  }

  @Test
  public void testHome() throws Exception {
    ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
      "http://localhost:" + this.port, String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(), entity
      .getBody().contains("<title>Yet"));
  }

  @Test
  public void testCss() throws Exception {
    ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
      "http://localhost:" + this.port
        + "/webjars/bootstrap/3.3.5/css/bootstrap.min.css", String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertTrue("Wrong body:\n" + entity.getBody(), entity.getBody().contains("body"));
    assertEquals("Wrong content type:\n" + entity.getHeaders().getContentType(),
      MediaType.valueOf("text/css;charset=UTF-8"), entity.getHeaders()
        .getContentType());
  }
}
