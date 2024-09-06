package org.egedede.ewordlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListControllerTest {

  @Value(value="${local.server.port}")
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void saveAndGetList() {
    String listEndpoint = "http://localhost:" + port + "/list";
    assertThat(this.restTemplate.getForEntity(listEndpoint + "/testList", String.class)
        .getStatusCode().value())
        .isEqualTo(404)
        ;
    this.restTemplate.put(listEndpoint + "?list=testList", null);
    assertThat(this.restTemplate.getForObject(listEndpoint + "/testList", String.class))
        .containsAnyOf("testList");
  }
}
