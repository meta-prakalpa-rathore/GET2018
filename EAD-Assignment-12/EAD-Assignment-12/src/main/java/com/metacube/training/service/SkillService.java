package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {

    public void addSkill(Skill skill);
    
    public List<Skill> getAllSkills();
    
    public Skill getSkillByName(String skill);
}
