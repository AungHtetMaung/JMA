package com.jms.servicecontroller.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jms.controlleraid.model.ExchangeRate;

public class RateRequestCBM {
	
	private static String rateRequest_CBM(){
		
		try {
			
	        URL u = new URL("http://forex.cbm.gov.mm/api/latest");
	        HttpURLConnection c = (HttpURLConnection) u.openConnection();
	        c.setRequestMethod("GET");
	        c.setRequestProperty("Content-length", "0");
	        c.setUseCaches(false);
	        c.setAllowUserInteraction(false);
	        c.setConnectTimeout(3600);
	        c.setReadTimeout(3600);
	        c.connect();
	        int status = c.getResponseCode();

	        switch (status) {
	            case 200:
	            case 201:
	                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
	                StringBuilder sb = new StringBuilder();
	                String line;
	                while ((line = br.readLine()) != null) {
	                    sb.append(line+"\n");
	                }
	                br.close();
	                System.out.println(sb.toString());
	                return sb.toString();
	        }

	    } catch (MalformedURLException ex) {
	        ex.printStackTrace();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		return null;
	}
	
	public static ExchangeRate rateParser_CBM(){
		
		ExchangeRate rate_CBM = new ExchangeRate();
		String responseMsg = rateRequest_CBM();
		
		JSONParser jsonParser = new JSONParser();
		try{
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(responseMsg);
			// get a String from the JSON object
			rate_CBM.setInFo((String) jsonObject.get("info"));
			rate_CBM.setDescription((String) jsonObject.get("description"));
			rate_CBM.setTimeStamp((String) jsonObject.get("timestamp"));
			
			// handle a structure into the json object
						JSONObject structure = (JSONObject) jsonObject.get("rates");
						System.out.println(structure.keySet().toString());
						String ccy = structure.keySet().toString();
						ccy = ccy.replace("[", "");ccy = ccy.replace("]", "");
						String[] ccys = ccy.trim().split(",");
						for(int i=0 ; i< ccys.length ; i++){							
							rate_CBM.getRates().put(ccys[i].trim(), (String) structure.get(ccys[i].trim().toString()));
							System.out.println("Rate :"+ccys[i]+" = " + structure.get(ccys[i].trim()));
						}
			
			return rate_CBM;
		}catch( ParseException | NullPointerException e){			
			e.printStackTrace();
		}
		return null;
	}
	}
