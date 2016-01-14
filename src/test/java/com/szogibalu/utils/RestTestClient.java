package com.szogibalu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestTestClient {

	public String executeGetRequest(String url) throws ClientProtocolException, IOException {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		return getResult(response);
	}

	private String getResult(HttpResponse response) throws IOException {
		String line = ""; 
		StringBuilder result = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}

}