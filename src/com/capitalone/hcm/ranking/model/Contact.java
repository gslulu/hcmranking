package com.capitalone.hcm.ranking.model;

import lombok.Data;

public @Data class Contact {
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String emailAddress;
	private String phoneNumber;
}
