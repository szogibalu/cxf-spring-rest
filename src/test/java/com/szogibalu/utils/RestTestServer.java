package com.szogibalu.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class RestTestServer {

	public final String TEST_CONTEXT = "/spring-cxf-rest";
	
	public final int TEST_PORT = 8080;
	
	private Server server;

	public RestTestServer() {
	}
	
	public void start() throws Exception {

		if (server == null) {
			server = new Server(TEST_PORT);
			server.setHandler(getContext());
			server.start();
		}
	}

	private WebAppContext getContext() {
		WebAppContext context = new WebAppContext();
		context.setDescriptor("src/test/resources/webapp/WEB-INF/web.xml");
		context.setResourceBase("src/test/resources/webapp");
		context.setContextPath(TEST_CONTEXT);
		context.setParentLoaderPriority(true);
		return context;
	}

	public void stop() throws Exception {
		if (server != null) {
			server.stop();
			server.join();
			server.destroy();
			server = null;
		}
	}
}