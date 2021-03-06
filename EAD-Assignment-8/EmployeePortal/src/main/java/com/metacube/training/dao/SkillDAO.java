package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {

    List<Skill> getAllSkills();

    boolean createSkill(Skill project);
    
    Skill getSkillByName(String skillName);
}
