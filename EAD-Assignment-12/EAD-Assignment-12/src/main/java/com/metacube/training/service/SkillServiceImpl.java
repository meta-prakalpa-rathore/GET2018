package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository<Skill> skillRepository;
    
    public void addSkill(Skill skill) {
               
        skillRepository.save(skill);
    }


	public List<Skill> getAllSkills() {
		
		return skillRepository.findAll();
	}


	public Skill getSkillByName(String skill) {

		return skillRepository.findByName(skill);
	}

}
