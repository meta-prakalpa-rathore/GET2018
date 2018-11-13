package com.metacube.training.model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Prakalpa-Rathore
 *
 */
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
    
    @Column(name = "description")
	private String description;
    
    @Column(name = "start_date")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date startDate;
    
    @Column(name = "end_date")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "project_logo", columnDefinition="MEDIUMBLOB")
    @Lob()
	private byte[] projectLogo;
    
//    @OneToMany(mappedBy="projectId")
//    private Set<JobDetails> jobDetails;
	
	
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}
	
	
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


    /**
     * @return the projectLogo
     */
    public byte[] getProjectLogo() {
        return projectLogo;
    }


    /**
     * @param projectLogo the projectLogo to set
     */
    public void setProjectLogo(byte[] projectLogo) {
        this.projectLogo = projectLogo;
    }


//    /**
//     * @return the jobDetails
//     */
//    public Set<JobDetails> getJobDetails() {
//        return jobDetails;
//    }
//
//
//    /**
//     * @param jobDetails the jobDetails to set
//     */
//    public void setJobDetails(Set<JobDetails> jobDetails) {
//        this.jobDetails = jobDetails;
//    }


    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", description="
                + description + ", startDate=" + startDate + ", endDate="
                + endDate + ", projectLogo=" + projectLogo + "]";
    }

}
