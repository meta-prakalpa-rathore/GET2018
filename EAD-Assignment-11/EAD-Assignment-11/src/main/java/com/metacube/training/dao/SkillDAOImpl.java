package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;

/**
 * @author Prakalpa-Rathore
 *
 */
@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {

	@Autowired
    private SessionFactory sessionFactory;       
        
    public List<Skill> getAllSkills() {
        
        TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skill");
        return query.getResultList();
    }

    
    public void createSkill(Skill skill) {
        
        sessionFactory.getCurrentSession().save(skill);
    }


    public Skill getSkillByName(String skillName) {
		
        TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skill where name = :name");
        query.setParameter("name", skillName);
        return query.getSingleResult();
	}


    @Override
    public Skill getSkillById(int id) {
        
        TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skill where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
