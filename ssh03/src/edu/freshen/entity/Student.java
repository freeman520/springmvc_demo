package edu.freshen.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="student"
    ,catalog="world"
)

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Department department;
     private String stuName;


    // Constructors

    /** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(Integer id, String stuName) {
        this.id = id;
        this.stuName = stuName;
    }
    
    /** full constructor */
    public Student(Integer id, Department department, String stuName) {
        this.id = id;
        this.department = department;
        this.stuName = stuName;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="depId")

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    @Column(name="stuName", nullable=false)

    public String getStuName() {
        return this.stuName;
    }
    
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
   








}