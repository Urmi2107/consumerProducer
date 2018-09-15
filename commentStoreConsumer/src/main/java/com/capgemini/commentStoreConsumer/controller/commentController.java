package com.capgemini.commentStoreConsumer.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class commentController {
	@Autowired
	private LoadBalancerClient loadBalancer;
	//private DiscoveryClient discoveryClient;
	@RequestMapping(value="/getlist/{pageId}",method=RequestMethod.GET)
	public String getList(@PathVariable String pageId)throws RestClientException,IOException
	{
		
		/*List<ServiceInstance>instances=discoveryClient.getInstances("zuul-service");
		ServiceInstance serviceInstance=instances.get(0);*/
		ServiceInstance serviceInstance=loadBalancer.choose("commentStoreProducer");
		System.out.println(serviceInstance.getUri());
		
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/commentlist/"+pageId;
		//String baseUrl="http://localhost:9000/commentlist/P01";
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String>response=null;
		try
		{
			response=restTemplate.exchange(baseUrl, HttpMethod.GET,getHeaders(),String.class);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println(response);
		return response.getBody();
		
	}
	private static HttpEntity<?> getHeaders()throws IOException {
		// TODO Auto-generated method stub
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		
		return new HttpEntity<>(headers);
	}
		

}
