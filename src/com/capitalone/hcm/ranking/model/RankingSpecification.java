package com.capitalone.hcm.ranking.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class RankingSpecification {
	//String type;
	
	private int weight; //1-100
	private boolean required;
	
	public RankingSpecification(int weight, boolean required) {
		super();
		this.weight = weight;
		this.required = required;
	}
	

}
