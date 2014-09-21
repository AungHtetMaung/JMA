package com.jms.controlleraid.model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
	
	private Long Id;
	private String inFo;
	private String description;
	private String timeStamp;
	
	private Map<String,String> rates =new HashMap<String, String>();

	public String getInFo() {
		return inFo;
	}

	public void setInFo(String inFo) {
		this.inFo = inFo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	

}
