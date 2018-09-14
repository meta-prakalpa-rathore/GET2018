package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

    private static SkillServiceImpl SkillServiceImpl = new SkillServiceImpl();
    
    @Autowired
    private SkillDAO skillDao;
    
    public static SkillServiceImpl getInstance() {
        
        return SkillServiceImpl;
    }
    
    
    public void addSkill(Skill skill) {
               
        skillDao.createSkill(skill);
    }


	public List<Skill> getAllSkills() {
		
		return skillDao.getAllSkills();
	}


	public Skill getSkillByName(String skill) {

		return skillDao.getSkillByName(skill);
	}

}
