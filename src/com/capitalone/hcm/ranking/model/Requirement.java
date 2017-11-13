package com.capitalone.hcm.ranking.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public @Data class Requirement extends Knowledge {

	private RankingSpecification rankSpecification;
	
	private int min = -1;
	private int max = -1;
	private boolean possess; 
}
