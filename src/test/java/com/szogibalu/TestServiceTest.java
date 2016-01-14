package com.szogibalu;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.szogibalu.utils.RestTestClient;
import com.szogibalu.utils.RestTestServer;

public class TestServiceTest {

	private static RestTestServer server = new RestTestServer();

	private static RestTestClient client = new RestTestClient();

	@BeforeClass
	public static void init() throws Exception {
		server.start();
	}

	@AfterClass
	public static void finish() throws Exception {
		server.stop();
	}

	@Test
	public void test() throws Exception {
		String value = client
				.executeGetRequest("http://localhost:8080/spring-cxf-rest/services/rest/testService/sayhello");
		assertEquals(value, "Hello world!");
	}

}
