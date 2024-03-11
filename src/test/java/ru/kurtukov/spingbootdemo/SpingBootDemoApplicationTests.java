package ru.kurtukov.spingbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpingBootDemoApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	private static final GenericContainer<?> devApp = new GenericContainer<>("devapp").withExposedPorts(8080);
	private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp").withExposedPorts(8081);

	@BeforeAll
	public static void setUp() {
		devApp.start();
		prodApp.start();
	}

	@Test
	void testDevAppPort() {
		String expected = "Current profile is dev";

		ResponseEntity<String> entityDevApp = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
		String result = entityDevApp.getBody();

		Assertions.assertEquals(expected, result);
	}

}
