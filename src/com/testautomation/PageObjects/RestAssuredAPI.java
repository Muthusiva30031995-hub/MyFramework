package com.testautomation.PageObjects;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;

import io.restassured.response.Response;

public class RestAssuredAPI extends PageBase{

	public RestAssuredAPI(InstanceContainer ic) {
		super(ic);
		
	}
	public Response response =null;
	Map<String,String> body = new HashMap();
	
	public void setup() throws Exception
	{
		String uri = excelData.getData("URI");
		wh.initializeHTTPRequest(uri);
	}
	
	public void GETOperation(String url) throws URISyntaxException
	{
		response = wh.GET(url);		
		
	}
	
	
	public void POSTOperation(String url) throws URISyntaxException
	{
		body.put("employee_name", "MS");
		body.put("employee_salary", "650000");
		body.put("employee_age", "25");
		response = wh.POSTWithBody(url,body);		
		
	}
	
	public void verifyStatusCode() throws Exception
	{
		String statusCode = excelData.getData("StatusCode");		
		int epectedStatusCode = Integer.parseInt(statusCode);		
		wh.validateStatusCode(response, epectedStatusCode);
				
	}
	
	public void verifyStatusLine() throws Exception
	{		
		String expectedStatusLine = excelData.getData("StatusLine"); 		
		wh.validateStatusLine(response, expectedStatusLine);		
	}
	
	public void verifyElement(String element) throws IOException
	{
		wh.validateResponseBodyContains(response,element);
	}
	
	public void verifyHeaderValue(String headerKey) throws Exception {
		
		String expectedHeaderValue = excelData.getData("Header"); 
		wh.validateHeaderValue(response, headerKey, expectedHeaderValue);
	}
	
	public void verifyResponseValue(String responseKey) throws Exception
	{
		String expectedResponseValue = excelData.getData("ResponseValue"); 
		wh.validateResponseValue(response, responseKey, expectedResponseValue);
		
	}

}
