package com.szogibalu.utils;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class RestTestClient {

	public String executeGetRequest(String url) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		return EntityUtils.toString(response.getEntity());
	}

	public String executePostRequest(String url, HttpEntity httpEntity, List<Header> headers) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);		
		request.setEntity(httpEntity);
		headers.forEach(request::addHeader);
		HttpResponse response = client.execute(request);

		return EntityUtils.toString(response.getEntity());
	}

}