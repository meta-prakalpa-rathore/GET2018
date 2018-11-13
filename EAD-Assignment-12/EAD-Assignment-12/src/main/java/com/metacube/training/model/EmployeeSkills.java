package com.metacube.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Skills")
public class EmployeeSkills {

    @Id
    @Column(name = "emp_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empSkillId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_code")
    private Employee employeeCode;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_code")
    private Skill skillCode;

    /**
     * @return the empSkillId
     */
    public int getEmpSkillId() {
        return empSkillId;
    }

    /**
     * @param empSkillId the empSkillId to set
     */
    public void setEmpSkillId(int empSkillId) {
        this.empSkillId = empSkillId;
    }

    /**
     * @return the employeeCode
     */
    public Employee getEmployeeCode() {
        return employeeCode;
    }

    /**
     * @param employeeCode the employeeCode to set
     */
    public void setEmployeeCode(Employee employeeCode) {
        this.employeeCode = employeeCode;
    }

    /**
     * @return the skillCode
     */
    public Skill getSkillCode() {
        return skillCode;
    }

    /**
     * @param skillCode the skillCode to set
     */
    public void setSkillCode(Skill skillCode) {
        this.skillCode = skillCode;
    }


    @Override
    public String toString() {
        return "EmployeeSkills [empSkillId=" + empSkillId + ", employeeCode="
                + employeeCode + ", skillCode=" + skillCode + "]";
    }
    
    
}
