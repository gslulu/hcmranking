package com.capitalone.hcm.ranking.model;

import java.util.Date;
import java.util.HashMap;

import lombok.Data;
import java.util.List;
import java.util.Map;

public @Data class Job {
	
	private String title;
	private Date openingDate;
	private Date startDate;
	
	private Employee hiringManager;
	private List<Employee> interviewers;
	
	private Map<Long, Requirement> requirements = new HashMap<Long, Requirement>();
	
}
