package com.capitalone.hcm.ranking.tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.capitalone.hcm.ranking.model.Job;
import com.capitalone.hcm.ranking.model.Knowledge;
import com.capitalone.hcm.ranking.model.Personnel;
import com.capitalone.hcm.ranking.model.RankingSpecification;
import com.capitalone.hcm.ranking.model.Requirement;
import com.capitalone.hcm.ranking.model.Skill;

public class RankingTooler {

	//Get the score / rank of a candidate for a particular job requirement
	//This will help the requiter to sort out the candidates
	static public int generateSystemRanking(Personnel personnel, Job job) {
		
		if (job == null || 				
				personnel == null) {			
			return 0;
		}
		
		int rank = 0;
	
		for(Entry<Long, Requirement> entry :job.getRequirements().entrySet()) {
			Requirement requirement = entry.getValue();
			if (entry == null || requirement == null) continue;
			RankingSpecification rankSpecification = requirement.getRankSpecification();
			
			if (rankSpecification == null) {
				continue;
			}

			
			if(!personnel.getSkills().containsKey(entry.getKey())) {
				if (rankSpecification.isRequired()) return 0;
				continue;
			}
			
			Skill skill = personnel.getSkills().get(entry.getKey());

			if (requirement.getGradingType().equals(Knowledge.KNOWLEDGE_GRADE_TYPE_BOOLEAN)) {
				if (requirement.isPossess() == skill.isHold()) {
					rank += 1 * rankSpecification.getWeight();
				}
			}  else if (requirement.getGradingType().equals(Knowledge.KNOWLEDGE_GRADE_TYPE_RANGE)) {
				//100% of the weight if the skill level is within the range required.  
				//level/min required % if the skill level is less than range required. --> Min 1-5 (Weight* 4/5)
				//1-level/max required % if the skill level is greater than range required --> Max 5-10 ( Weight * (1 - ((10-8)/8) ))
				if (skill.getLevel() >= requirement.getMin() && skill.getLevel() <= requirement.getMax()) {
					rank += 1 * rankSpecification.getWeight();
				} else if (skill.getLevel() < requirement.getMin()) {
					rank += skill.getLevel()/requirement.getMin() * rankSpecification.getWeight();					
				} else if (skill.getLevel() > requirement.getMax()) {
					float percentage = ((float)(skill.getLevel() - requirement.getMax()))/ (float) requirement.getMax();  
					rank += (1 - percentage) * rankSpecification.getWeight();					
				}					
			}

		}
		return rank;				
 
	}

}
