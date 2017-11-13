package com.capitalone.hcm.ranking.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.Data;

public @Data class Personnel {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Contact contact;
	
	
	//private List<Skill> skills = new LinkedList<Skill>();
	private Map<Long, Skill> skills = new HashMap<Long, Skill>();
	
	//Map of Skill Name and the Ranking -- Entered by Managers / Interview
	//Key of the external map - Manager's / Interview's Employee Id is the 
	//Key of the internal map - Skill Name  
	private Map<Long, Map<String, Integer>> ranking = new HashMap<Long,Map<String, Integer>>();

	
	
}
