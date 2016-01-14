package com.szogibalu;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService(serviceName = "testService")
@Consumes({ APPLICATION_JSON })
@Produces({ APPLICATION_JSON })
@Path("/testService")
public class TestService {

	@GET
	@Path("/sayhello")
	public String sayHello() {
		return "Hello world!";
	}

}
