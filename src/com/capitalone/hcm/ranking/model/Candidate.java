package com.capitalone.hcm.ranking.model;

import lombok.Data;

public @Data class Candidate extends Personnel{
	
	private String preferredContactMethod;
	private String resumeFormat;
	private String resumePath;	

}
