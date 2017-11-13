package com.capitalone.hcm.ranking.tools;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.capitalone.hcm.ranking.model.Job;
import com.capitalone.hcm.ranking.model.Personnel;
import com.capitalone.hcm.ranking.model.RankingSpecification;
import com.capitalone.hcm.ranking.model.Requirement;
import com.capitalone.hcm.ranking.model.Skill;

class RankingToolerTest1 extends RankingTooler {

	Job job = buildJob();
	
	private Job buildJob() {
		
		Job job = new Job();
		
		Requirement requirement1 = new Requirement();
		requirement1.setId((long) 1);
		requirement1.setName("Java");
		requirement1.setType(Requirement.KNOWLEDGE_TYPE_TECHNICAL);
		requirement1.setGradingType(Requirement.KNOWLEDGE_GRADE_TYPE_RANGE);
		requirement1.setMin(4);
		requirement1.setMax(7);
		requirement1.setRankSpecification(new RankingSpecification(30, true));
		job.getRequirements().put(requirement1.getId(), requirement1);

		Requirement requirement2 = new Requirement();
		requirement2.setId((long) 2);
		requirement2.setName("AWS Certification");
		requirement2.setType(Requirement.KNOWLEDGE_TYPE_CERTIFICATION);
		requirement2.setGradingType(Requirement.KNOWLEDGE_GRADE_TYPE_BOOLEAN);
		requirement2.setPossess(true);		
		requirement2.setRankSpecification(new RankingSpecification(10, true));
		job.getRequirements().put(requirement2.getId(), requirement2);

		Requirement requirement3 = new Requirement();
		requirement3.setId((long) 3);
		requirement3.setName("Analytical");
		requirement3.setType(Requirement.KNOWLEDGE_TYPE_BEHAVIOR);
		requirement3.setGradingType(Requirement.KNOWLEDGE_GRADE_TYPE_BOOLEAN);
		requirement3.setPossess(true);	
		requirement3.setRankSpecification(new RankingSpecification(10, false));
		job.getRequirements().put(requirement3.getId(), requirement3);
		

		Requirement requirement4 = new Requirement();
		requirement4.setId((long) 4);
		requirement4.setName("Masters");
		requirement4.setType(Requirement.KNOWLEDGE_TYPE_TECHNICAL);
		requirement4.setGradingType(Requirement.KNOWLEDGE_GRADE_TYPE_BOOLEAN);
		requirement4.setPossess(false);	
		requirement4.setRankSpecification(new RankingSpecification(20, false));
		job.getRequirements().put(requirement4.getId(), requirement4);


		Requirement requirement5 = new Requirement();
		requirement5.setId((long) 5);
		requirement5.setName("Salary");
		requirement5.setType(Requirement.KNOWLEDGE_TYPE_OTHER);
		requirement5.setGradingType(Requirement.KNOWLEDGE_GRADE_TYPE_RANGE);
		requirement5.setMin(111000);
		requirement5.setMax(150000);
		requirement5.setRankSpecification(new RankingSpecification(30, false));
		job.getRequirements().put(requirement5.getId(), requirement5);
		
		return job;
		
	}
	
	@Test
	void testBuildSystemRankings1() {
		buildJob();

		Personnel personnel = new Personnel();
		personnel.setId((long) 1);;
		personnel.setFirstName("First");
		personnel.setLastName("Candidate");
		
		Skill skill1 = new Skill();
		skill1.setId((long) 1);
		skill1.setLevel(5);
		
		personnel.getSkills().put(skill1.getId(), skill1);
		
		
		int rank = RankingTooler.generateSystemRanking(personnel, job);

		assert(rank == 0);
		
		//fail("Not yet implemented");
	}

	@Test
	void testBuildSystemRankings2() {
		buildJob();

		Personnel personnel = new Personnel();
		personnel.setId((long) 1);;
		personnel.setFirstName("First");
		personnel.setLastName("Candidate");
		
		Skill skill1 = new Skill();
		skill1.setId((long) 1);
		skill1.setLevel(5);
		
		personnel.getSkills().put(skill1.getId(), skill1);
		
		Skill skill2 = new Skill();
		skill2.setId((long) 2);
		skill2.setHold(true);
		
		personnel.getSkills().put(skill2.getId(), skill2);
		
		
		int rank = RankingTooler.generateSystemRanking(personnel, job);

		assert(rank == 40);

		//fail("Not yet implemented");
	}
	
	
	@Test
	void testBuildSystemRankings3() {
		buildJob();

		Personnel personnel = new Personnel();
		personnel.setId((long) 1);;
		personnel.setFirstName("First");
		personnel.setLastName("Candidate");
		
		Skill skill1 = new Skill();
		skill1.setId((long) 1);
		skill1.setLevel(5);
		
		personnel.getSkills().put(skill1.getId(), skill1);
		
		Skill skill2 = new Skill();
		skill2.setId((long) 2);
		skill2.setHold(true);
		
		personnel.getSkills().put(skill2.getId(), skill2);
		

		Skill skill3 = new Skill();
		skill3.setId((long) 3);
		skill3.setHold(true);
		
		personnel.getSkills().put(skill3.getId(), skill3);

		int rank = RankingTooler.generateSystemRanking(personnel, job);

		assert(rank == 50);

		//fail("Not yet implemented");
	}
	
	
	@Test
	void testBuildSystemRankings4() {
		buildJob();

		Personnel personnel = new Personnel();
		personnel.setId((long) 1);;
		personnel.setFirstName("First");
		personnel.setLastName("Candidate");
		
		Skill skill1 = new Skill();
		skill1.setId((long) 1);
		skill1.setLevel(5);
		
		personnel.getSkills().put(skill1.getId(), skill1);
		
		Skill skill2 = new Skill();
		skill2.setId((long) 2);
		skill2.setHold(true);
		
		personnel.getSkills().put(skill2.getId(), skill2);
		

		Skill skill3 = new Skill();
		skill3.setId((long) 3);
		skill3.setHold(true);
		
		personnel.getSkills().put(skill3.getId(), skill3);


		Skill skill4 = new Skill();
		skill4.setId((long) 4);
		skill4.setHold(false);
		
		personnel.getSkills().put(skill4.getId(), skill4);
		int rank = RankingTooler.generateSystemRanking(personnel, job);

		assert(rank == 70);

		//fail("Not yet implemented");
	}

	
	@Test
	void testBuildSystemRankings5() {
		buildJob();

		Personnel personnel = new Personnel();
		personnel.setId((long) 1);;
		personnel.setFirstName("First");
		personnel.setLastName("Candidate");
		
		Skill skill1 = new Skill();
		skill1.setId((long) 1);
		skill1.setLevel(5);
		
		personnel.getSkills().put(skill1.getId(), skill1);
		
		Skill skill2 = new Skill();
		skill2.setId((long) 2);
		skill2.setHold(true);
		
		personnel.getSkills().put(skill2.getId(), skill2);
		

		Skill skill3 = new Skill();
		skill3.setId((long) 3);
		skill3.setHold(true);
		
		personnel.getSkills().put(skill3.getId(), skill3);


		Skill skill4 = new Skill();
		skill4.setId((long) 4);
		skill4.setHold(false);
		
		personnel.getSkills().put(skill4.getId(), skill4);

		Skill skill5 = new Skill();
		skill5.setId((long) 5);
		skill5.setLevel(111001);
		
		personnel.getSkills().put(skill5.getId(), skill5);

		int rank = RankingTooler.generateSystemRanking(personnel, job);

		assert(rank == 100);

		//fail("Not yet implemented");
	}
}
