package edu.freshen.entity;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="department"
    ,catalog="world"
)

public class Department  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String depName;
     //private Set<Student> students = new HashSet<Student>(0);


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(Integer id, String depName) {
        this.id = id;
        this.depName = depName;
    }
    
    /** full constructor */
    public Department(Integer id, String depName, Set<Student> students) {
        this.id = id;
        this.depName = depName;
       // this.students = students;
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
    
    @Column(name="depName", nullable=false)

    public String getDepName() {
        return this.depName;
    }
    
    public void setDepName(String depName) {
        this.depName = depName;
    }
/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="department")

    public Set<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
   
*/







}