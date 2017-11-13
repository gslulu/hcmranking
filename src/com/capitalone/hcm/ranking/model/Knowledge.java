package com.capitalone.hcm.ranking.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class Knowledge {



	//public static final String KNOWLEDGE_ANALYTICAL = "Analytical";
	//public static final String KNOWLEDGE_SERIOUS = "Serious";
	//public static final String KNOWLEDGE_METICULOUS = "Meticulous";
	//public static final String KNOWLEDGE_CONTEMPLATIVE = "Contemplative";
			
	public static final String KNOWLEDGE_TYPE_EDUCATION = "Education";
	public static final String KNOWLEDGE_TYPE_TECHNICAL = "Technical";
	public static final String KNOWLEDGE_TYPE_CERTIFICATION = "Certification";
	public static final String KNOWLEDGE_TYPE_BEHAVIOR = "Behavior";
	public static final String KNOWLEDGE_TYPE_OTHER = "Other";
	
	
	public static final String KNOWLEDGE_GRADE_TYPE_BOOLEAN = "Boolean";	
	public static final String KNOWLEDGE_GRADE_TYPE_RANGE = "Range";
	
	private Long id;
	private String name;
	private String description;

	//Education, Behavior, Technical, Certification, etc
	private String type;

	//Boolean Check, Range Check
	private String gradingType;
	
	
/*	public boolean equals(Knowledge obj) {
		//Check if the names are same 
		if (obj == null) return false;
		
		if (name != null && obj.name != null && name.trim().equalsIgnoreCase(obj.name.trim())) {
			return true;
		}
		return false;
	}
*/
	}
