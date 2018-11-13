package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Skill;

/**
 * @author Prakalpa-Rathore
 *
 */
@Repository
public class SkillDAOImpl implements SkillDAO {

	private JdbcTemplate jdbcTemplate;
    

    @Autowired
    public SkillDAOImpl(DataSource dataSource) {
        
    	jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    private static final String SQL_FIND_SKILL = "SELECT * "
            + "FROM skills "
            + "WHERE skill_name = ?";

    private static final String SQL_GET_ALL = "SELECT * FROM skills";

    private static final String SQL_INSERT_SKILL = "INSERT INTO skills(skill_name) "
            + "VALUES (?)";
    
        
    public List<Skill> getAllSkills() {
        
        return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
    }

    
    public boolean createSkill(Skill skill) {
        
        return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getName()) > 0;
    }


    public Skill getSkillByName(String skillName) {
		
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { skillName }, new SkillMapper());
	}
}
